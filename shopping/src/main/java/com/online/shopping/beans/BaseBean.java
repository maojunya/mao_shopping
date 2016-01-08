
package com.online.shopping.beans;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BaseBean {

    private User createdBy;
    private User updateBy;
    private Date createdDate;
    private Date updatedDate;
    
}
