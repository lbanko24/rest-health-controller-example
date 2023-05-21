package com.example.healthcontroller.service;

import java.util.List;
import java.util.Optional;

import com.example.healthcontroller.entity.Message;

public interface MessageService {
	Message save(Message message);

	Optional<Message> getById(Long id);
	
	List<Message> getAll();
}
