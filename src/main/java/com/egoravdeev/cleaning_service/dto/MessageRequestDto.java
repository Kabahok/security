package com.egoravdeev.cleaning_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageRequestDto {
    private String messageText;
    private String recipient;
    private String email;
    private String name;

}
