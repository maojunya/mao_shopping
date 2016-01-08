
package com.online.shopping.service;

import com.online.shopping.beans.User;


public interface LoginService {
    /**
     *  Get user with its id, this id is added by DBA.
     */
    public User getUserById(String uid) throws Exception;

}
