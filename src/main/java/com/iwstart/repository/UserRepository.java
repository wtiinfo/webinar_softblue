package com.iwstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iwstart.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
