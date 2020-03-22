package ru.itis.hateoasrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class UserDto {

    @NotBlank
    private String login;

    @NotBlank
    private String password;
}
