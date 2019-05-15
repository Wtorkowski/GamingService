package com.gamingService.validators;

import com.gamingService.annotations.RepeatPassword;
import com.gamingService.dto.RegistrationFormDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class RepeatPasswordValidator implements ConstraintValidator<RepeatPassword, RegistrationFormDTO> {

    @Override
    public void initialize(RepeatPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(RegistrationFormDTO registrationFormDTO,
                           ConstraintValidatorContext context) {
        return Objects.equals(registrationFormDTO.getPassword(),
                registrationFormDTO.getRepeatPassword());
    }
}
