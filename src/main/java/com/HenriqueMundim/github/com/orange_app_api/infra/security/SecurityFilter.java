package com.HenriqueMundim.github.com.orange_app_api.infra.security;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.domain.services.token.TokenService;
import com.HenriqueMundim.github.com.orange_app_api.infra.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    private final UserRepository userRepository;

    @Autowired
    public SecurityFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = recoverToken(request);

            if (token != null) {
                String username = this.tokenService.validateToken(token);
                User user = this.userRepository.findByUsername(username);

                if (user != null) {
                    var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                } else {
//                    SecurityContextHolder.getContext().setAuthentication(null);
                }

            }

            filterChain.doFilter(request, response);

        } catch (Exception exception) {
            System.out.println(exception.getStackTrace());
        }
    }

    private String recoverToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        
        if (authorization != null && authorization.startsWith("Bearer ")) {
            return authorization.substring(7).trim(); 
        }
        return null; 
    }
}
