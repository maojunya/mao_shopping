package com.online.shopping.service.impl;

import java.util.Arrays;
import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.online.shopping.beans.User;
import com.online.shopping.dao.LoginDao;
import com.online.shopping.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
    
    @Resource
    private LoginDao loginDao;      
   
    @Override
    public User getUserById(String uid) throws Exception {
        return loginDao.getUserById(uid);
    }

}
