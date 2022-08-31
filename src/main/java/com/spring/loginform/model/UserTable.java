package com.spring.loginform.model;
 
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="User_data1")
public class UserTable {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    //@SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq")
	private Integer id; 
	
	private String login;
	
	private String email;
	
	private String password;

		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserTable other = (UserTable) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(login, other.login)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "UserTable [id=" + id + ", login=" + login + ", email=" + email + "]";
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return true;
	}
	
		
}
