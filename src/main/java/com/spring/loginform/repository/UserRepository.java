package com.spring.loginform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.loginform.model.UserTable;

public interface UserRepository extends JpaRepository<UserTable, Integer> {
	
	

	public UserTable findByLoginAndPassword(String login, String password);
	
	public UserTable findFirstByLogin(String login);
	

}
