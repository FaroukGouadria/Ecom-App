package com.dao;

import com.entity.User;

public interface userdao {
	public boolean userRegister(User us);
	public User userlogin(String email, String password);
}
