package com.bookshop.service;

import com.bookshop.dto.user.UserRegistrationRequest;
import com.bookshop.dto.user.UserResponseDto;
import com.bookshop.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequest request) throws RegistrationException;
}
