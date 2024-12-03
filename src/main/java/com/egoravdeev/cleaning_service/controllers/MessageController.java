package com.egoravdeev.cleaning_service.controllers;

import com.egoravdeev.cleaning_service.dto.MessageRequestDto;
import com.egoravdeev.cleaning_service.model.Message;
import com.egoravdeev.cleaning_service.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/message")
    public void createMessage(@RequestBody MessageRequestDto messageRequestDto) {
        messageService.createNewMessage(
                Message.builder().messageText(messageRequestDto.getMessageText())
                        .author(messageRequestDto.getName())
                        .recipient(messageRequestDto.getRecipient())
                        .email(messageRequestDto.getEmail()).build()
        );
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

}
