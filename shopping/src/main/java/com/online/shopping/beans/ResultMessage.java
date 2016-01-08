
package com.online.shopping.beans;

import java.io.Serializable;

import com.online.shopping.common.RespStatus;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ResultMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int code = 0; //0: failed
    private RespStatus result;
    private String message;
    private String description;
    private Object resultObject;
    
    @Override
    public String toString() {
        StringBuffer rs = new StringBuffer();
        rs.append("{");
        rs.append("\"code\":\"");
        rs.append(code);
        rs.append("\", \"result\":\"");
        rs.append(result);
        rs.append("\", \"message\":\"");
        rs.append(message);
        rs.append("\", \"description\":\"");
        rs.append(description);
        rs.append("\"}");
        
        return rs.toString();
    }
}
