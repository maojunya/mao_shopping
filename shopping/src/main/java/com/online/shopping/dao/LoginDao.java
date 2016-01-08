package com.online.shopping.dao;

import com.online.shopping.beans.User;

public interface LoginDao {
	
	public User getUserById(String uid) throws Exception;
    
}
