package com.iwstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iwstart.model.Mensagem;

public interface MessageRepository extends JpaRepository<Mensagem, Long> {
}
