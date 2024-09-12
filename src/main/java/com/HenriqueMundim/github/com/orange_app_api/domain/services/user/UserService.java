package com.HenriqueMundim.github.com.orange_app_api.domain.services.user;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.OutputUserDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.mapper.UserMapper;
import com.HenriqueMundim.github.com.orange_app_api.infra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public OutputUserDTO getUserByUsername(String username) {
        User user = this.userRepository.findByUsername(username);

        return UserMapper.toDomain(user);
    }
    
    public User getUserById(Integer id) {
    	return this.userRepository.findById(id).orElse(null);
    }
}
