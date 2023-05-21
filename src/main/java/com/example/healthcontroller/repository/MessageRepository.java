package com.example.healthcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.healthcontroller.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
