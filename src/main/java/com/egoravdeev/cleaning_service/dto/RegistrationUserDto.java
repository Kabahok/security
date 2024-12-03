package com.egoravdeev.cleaning_service.dto;

import lombok.Data;

@Data
public class RegistrationUserDto {
    private String name;
    private String login;
    private String password;
    private String email;

}
