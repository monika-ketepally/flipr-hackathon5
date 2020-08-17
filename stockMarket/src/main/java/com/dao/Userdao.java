package com.dao;

import com.db.Hibernate;
import com.dto.User;

public class Userdao {

	public int register(User user) {
		// TODO Auto-generated method stub
		return Hibernate.addObject(user);
	}

	public User login(String email, String password) {
		// TODO Auto-generated method stub
		return Hibernate.login(email,password);
	}

}
