package com.spring.loginform.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;

import com.spring.loginform.model.UserTable;
import com.spring.loginform.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserTable registerUser(String login, String password, String email) {

		if (login == null || password == null){
			//System.out.println("Duplicate login");
			return null;
			
		}

		else { 
			//if(userRepository.findFirstByLogin(login).isPresent() ) {
			//return null;
			//}
			UserTable usertable = new UserTable();
			usertable.setLogin(login);
			usertable.setPassword(password);
			usertable.setEmail(email);
			return userRepository.save(usertable);
		}
	}

	public UserTable findByLoginAndPassword(String login, String password) {
		return userRepository.findByLoginAndPassword(login, password);
	}

}
