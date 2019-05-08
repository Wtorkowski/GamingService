package com.gamingService.dto;

import com.gamingService.annotations.RepeatPassword;
import com.gamingService.annotations.UniqueUserName;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@RepeatPassword
public class RegistrationFormDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    @UniqueUserName
    private String userName;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,20}$",
            message = "{registration.userPassword.pattern}")
    private String password;

    private String repeatPassword;

    public String getUserName() {
        return userName;
    }

    public RegistrationFormDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationFormDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public RegistrationFormDTO setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
        return this;
    }
}
