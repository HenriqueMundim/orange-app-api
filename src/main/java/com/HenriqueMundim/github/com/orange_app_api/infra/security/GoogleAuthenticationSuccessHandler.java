package com.HenriqueMundim.github.com.orange_app_api.infra.security;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.domain.services.auth.AuthService;
import com.HenriqueMundim.github.com.orange_app_api.domain.services.token.TokenService;
import com.HenriqueMundim.github.com.orange_app_api.infra.repositories.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GoogleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectUrl = "";
        String token = "";

        if (authentication.getPrincipal() instanceof DefaultOAuth2User userDetails) {
            String username = userDetails.getAttribute("email") != null ? userDetails.getAttribute("email") : userDetails.getAttribute("login") + "@gmail.com";

            if (this.userRepository.findByUsername(username) == null) {
                User user = new User();
                user.setName(userDetails.getAttribute("name"));
                user.setEmail(username);

                this.userRepository.save(user);
            }

            redirectUrl = "http://localhost:4200/home";
            token = this.tokenService.generateToken(this.userRepository.findByUsername(username));
        }

        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);

        new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
}
