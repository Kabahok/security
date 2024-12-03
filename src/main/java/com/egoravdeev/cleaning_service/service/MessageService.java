package com.egoravdeev.cleaning_service.service;

import com.egoravdeev.cleaning_service.model.Message;
import com.egoravdeev.cleaning_service.repositories.MessageRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public void createNewMessage(Message message) {
        messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
