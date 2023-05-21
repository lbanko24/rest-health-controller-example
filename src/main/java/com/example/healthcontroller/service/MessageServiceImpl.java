package com.example.healthcontroller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthcontroller.entity.Message;
import com.example.healthcontroller.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public Message save(Message message) {
		return messageRepository.save(message);
	}

	@Override
	public Optional<Message> getById(Long id) {
		return messageRepository.findById(id);
	}

	@Override
	public List<Message> getAll() {
		return messageRepository.findAll();
	}

}
