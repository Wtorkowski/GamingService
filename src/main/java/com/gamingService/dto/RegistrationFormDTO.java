package com.gamingService.dto;

import com.gamingService.annotations.RepeatPassword;
import com.gamingService.annotations.UniqueUserName;
import lombok.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@RepeatPassword
@Builder
public class RegistrationFormDTO {

    @Size(min = 3, max = 20, message = "Wrong user name pattern!")
    @UniqueUserName
    private String userName;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,20}$",
            message = "Wrong password pattern!")
    private String password;

    private String repeatPassword;
}
