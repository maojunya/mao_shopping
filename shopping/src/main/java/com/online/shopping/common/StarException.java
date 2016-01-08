
package com.online.shopping.common;

import org.apache.log4j.Logger;

/**
 *
 */
public class StarException extends RuntimeException {
    Logger logger = Logger.getLogger(getClass());
    
    private static final long serialVersionUID = 1L;
    
    public StarException() {
        super();
    }
    
    public StarException(String _message) {
        super(_message);
        logger.error(_message);
    }
    
    public StarException(String _message, Throwable t) {
        super(_message, t);
        logger.error(_message, t);
    }
}
