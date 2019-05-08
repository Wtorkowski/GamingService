package com.gamingService.validators;

import com.gamingService.annotations.UniqueUserName;
import com.gamingService.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@AllArgsConstructor
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    private UserRepository userRepository;

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        return userRepository.isUsernameAvailable(userName);
    }

    @Override
    public void initialize(UniqueUserName constraintAnnotation) {

    }
}
