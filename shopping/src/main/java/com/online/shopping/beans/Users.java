
package com.online.shopping.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Users extends BaseBean implements Serializable {

    private static final long serialVersionUID = 2L;    
    @Valid
    private ArrayList<User> userList;
    
    
	public String toString () {
        return "userId: ";
    }

}
