package com.iwstart.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.iwstart.model.User;
import com.iwstart.repository.UserRepository;

@Component
public class StartUpApplicationListener {
	
	@Autowired
	private UserRepository userRepo;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		User u1 = new User();
		u1.setId("wborges");
		u1.setName("Wando Borges");
		
		userRepo.save(u1);
		
		User u2 = new User();
		u2.setId("westevam");
		u2.setName("Wando Estevam");
		
		userRepo.save(u2);
	}
	
}
