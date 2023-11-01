package com.bookshop.dto.user;

import com.bookshop.annotation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@FieldMatch
public record UserRegistrationRequestDto(@NotBlank @Email String email,
                                         @NotBlank @Size(min = 7, max = 20) String password,
                                         @NotBlank @Size(min = 7, max = 20) String repeatPassword,
                                         @NotBlank String firstName,
                                         @NotBlank String lastName,
                                         String shippingAddress) {

}
