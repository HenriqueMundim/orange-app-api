package com.HenriqueMundim.github.com.orange_app_api.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.domain.enums.UserRole;
import com.HenriqueMundim.github.com.orange_app_api.domain.errors.ResourceAlreadyExistsException;
import com.HenriqueMundim.github.com.orange_app_api.domain.services.auth.AuthService;
import com.HenriqueMundim.github.com.orange_app_api.domain.services.token.TokenService;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.InputUserDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.mapper.UserMapper;
import com.HenriqueMundim.github.com.orange_app_api.infra.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTests {
	
	@InjectMocks
	private AuthService authService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
    private AuthenticationManager authenticationManager;
	
	@Mock
    private TokenService tokenService;
	
	private static InputUserDTO user = new InputUserDTO("John", "john@email.com", "Doe", "123456", UserRole.USER);
	private static User userEntity = new User("John", "john@email.com", "Doe", "123456", UserRole.USER);
	
	@Test
	public void createuserWithValidData() {
		when(this.userRepository.findByUsername(user.getEmail())).thenReturn(null);
		when(this.userRepository.save(UserMapper.toEntity(user))).thenReturn(userEntity);
		
		User sut = this.authService.enroll(user);
		
		assertEquals(sut, userEntity);
	}
	
	@Test
	public void createUserWithInvalidDataThrowsResourceAlreadyExistException() {
		when(this.userRepository.findByUsername(user.getEmail())).thenReturn(new User());
		
		ResourceAlreadyExistsException exception = assertThrows(ResourceAlreadyExistsException.class, () -> {
			this.authService.enroll(user);
		});
		
		assertEquals("User already exists", exception.getMessage());
		verify(userRepository, never()).save(userEntity);
	}
	
}
