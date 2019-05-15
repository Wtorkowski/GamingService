package com.gamingService.dto;

import com.gamingService.annotations.RepeatPassword;
import com.gamingService.annotations.UniqueUserName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@Setter
@Getter
@RepeatPassword
public class RegistrationFormDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    @UniqueUserName
    private String userName;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,20}$",
            message = "Wrong password pattern!")
    private String password;

    private String repeatPassword;

}
