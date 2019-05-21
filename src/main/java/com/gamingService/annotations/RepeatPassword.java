package com.gamingService.annotations;


import com.gamingService.validators.RepeatPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RepeatPasswordValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatPassword {

    String message() default "Passwords are not the same!";

    String path() default "password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
