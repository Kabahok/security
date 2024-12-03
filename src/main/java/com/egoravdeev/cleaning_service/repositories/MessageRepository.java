package com.egoravdeev.cleaning_service.repositories;

import com.egoravdeev.cleaning_service.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
