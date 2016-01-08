
package com.online.shopping.common;


public class CustomedException extends Exception {

    private static final long serialVersionUID = 1L;

    private String message;
    private Object data;
    
    public CustomedException(String _message) {
        this.message = _message;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
}
