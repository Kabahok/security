package com.egoravdeev.cleaning_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private long id;

    @Column(nullable = false, name = "message_text")
    private String messageText;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String recipient;

    @Column(nullable = false)
    private String email;
}
