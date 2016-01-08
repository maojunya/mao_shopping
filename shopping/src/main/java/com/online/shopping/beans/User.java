
package com.online.shopping.beans;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;    
   
    private String userId;  
    private String password;
    private String firstName;  
    private String lastName;
   
	public String toString () {
        return "userId: " + userId;
    }

}
