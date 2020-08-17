package com.dinesh.newboot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.newboot.model.User;


public interface UserService extends JpaRepository<User, Long>  {
	public User findByUsername(String username);
}
