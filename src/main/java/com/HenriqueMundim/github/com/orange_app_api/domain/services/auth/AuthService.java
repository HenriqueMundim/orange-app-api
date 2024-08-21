package com.HenriqueMundim.github.com.orange_app_api.domain.services.auth;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.domain.errors.ResourceAlreadyExistsException;
import com.HenriqueMundim.github.com.orange_app_api.domain.services.token.TokenService;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.InputUserDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.UserLoginDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.mapper.UserMapper;
import com.HenriqueMundim.github.com.orange_app_api.infra.repositories.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public AuthService(UserRepository userRepository, @Lazy AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username);
    }

    public String authenticate(UserLoginDTO data) {
        var authToken = new UsernamePasswordAuthenticationToken(data.username, data.password);
        var auth = this.authenticationManager.authenticate(authToken);
   
        return tokenService.generateToken((User) auth.getPrincipal());
    }

    public User enroll(InputUserDTO user) {
        User isExist = userRepository.findByUsername(user.getEmail());

        if (isExist != null) {
            throw new ResourceAlreadyExistsException("User already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encryptedPassword);
        
        return userRepository.save(UserMapper.toEntity(user));
    }
}
