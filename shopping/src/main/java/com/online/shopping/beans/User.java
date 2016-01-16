
package com.online.shopping.beans;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class User extends BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;   
    
    @NotNull
    private String userId;  
    @Size(min = 2, max = 14)
    private String password;
    @Min(2)
    private String firstName;  
    @NotEmpty(message="not null")
    private String lastName;
   
	public String toString () {
        return "userId: " + userId;
    }

}
