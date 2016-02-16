package com.online.shopping.dao;

import java.util.HashMap;

import com.online.shopping.beans.User;

public interface LoginDao {
	
	public User getUserById(HashMap<String, String> hs) throws Exception;
    
}
