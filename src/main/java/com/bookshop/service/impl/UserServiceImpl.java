package com.bookshop.service.impl;

import com.bookshop.dto.user.UserRegistrationRequest;
import com.bookshop.dto.user.UserResponseDto;
import com.bookshop.exception.RegistrationException;
import com.bookshop.mapper.UserMapper;
import com.bookshop.model.User;
import com.bookshop.repository.UserRepository;
import com.bookshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    @Override
    public UserResponseDto register(UserRegistrationRequest request) throws RegistrationException {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new RegistrationException("Unable to complete registration.");
        }
        User user = new User();
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setEmail(request.email());
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }
}
