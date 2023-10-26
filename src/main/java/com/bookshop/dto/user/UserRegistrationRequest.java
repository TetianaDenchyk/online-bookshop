package com.bookshop.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegistrationRequest (@NotBlank @Email String email,
                                       @NotBlank @Size(min = 7, max = 20) String password,
                                       @NotBlank String firstName,
                                       @NotBlank String lastName,
                                       String shoppingAddress) {
}
