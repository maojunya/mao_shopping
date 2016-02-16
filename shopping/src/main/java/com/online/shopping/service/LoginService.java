
package com.online.shopping.service;

import java.util.HashMap;
import java.util.List;

import com.online.shopping.beans.User;
import com.online.shopping.domain.Contact;


public interface LoginService {
    /**
     *  Get user with its id, this id is added by DBA.
     */
    public User getUserById(HashMap<String, String> hs) throws Exception;
    
    public List<Contact> findAllContact()  throws Exception;
    
    public List<Contact> findAllWithDetail()  throws Exception;

}
