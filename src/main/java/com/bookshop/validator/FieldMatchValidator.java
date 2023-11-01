package com.bookshop.validator;

import com.bookshop.annotation.FieldMatch;
import com.bookshop.dto.user.UserRegistrationRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements
        ConstraintValidator<FieldMatch, UserRegistrationRequestDto> {
    @Override
    public boolean isValid(UserRegistrationRequestDto value, ConstraintValidatorContext context) {
        String firstField = value.password();
        String secondField = value.repeatPassword();
        return firstField != null && firstField.equals(secondField);
    }
}
