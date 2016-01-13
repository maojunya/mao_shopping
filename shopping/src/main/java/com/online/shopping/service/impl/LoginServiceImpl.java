package com.online.shopping.service.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.online.shopping.beans.User;
import com.online.shopping.dao.ContactDao;
import com.online.shopping.dao.LoginDao;
import com.online.shopping.domain.Contact;
import com.online.shopping.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
    
    @Resource
    private LoginDao loginDao;    
    
    @Resource
    private ContactDao contactDao;
   
    @Override
    public User getUserById(String uid) throws Exception {
        return loginDao.getUserById(uid);
    }

	@Override
	public List<Contact> findAllContact() throws Exception {
		// TODO Auto-generated method stub
		return contactDao.findAll();
	}

	@Override
	public List<Contact> findAllWithDetail() throws Exception {
		// TODO Auto-generated method stub
		return contactDao.findAllWithDetail();
	}

}
