package com.example.healthcontroller.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.healthcontroller.entity.Message;
import com.example.healthcontroller.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping
	public ResponseEntity<Void> postMessage(@RequestBody Message message) {
		Message created = messageService.save(message);
		
		return ResponseEntity.created(URI.create("/message/" + created.getId())).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Message> getMessage(@PathVariable Long id) {
		Optional<Message> found = messageService.getById(id);
		
		if (found.isPresent()) {
			return ResponseEntity.ok(found.get());
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<Message>> getAllMessages() {
		return ResponseEntity.ok(messageService.getAll());
	}
}
