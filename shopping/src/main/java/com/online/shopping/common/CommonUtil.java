
package com.online.shopping.common;

import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;


public class CommonUtil {
	/**
	 * Change First character to lowercase
	 */
    public static String toLowerCaseFirstOne(String s) {
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    
    /**
	 * Change First character to uppercase
	 */
    public static String toUpperCaseFirstOne(String s) {
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    
    /**
     * Get the properties value against the specified key.
     * 
     * @param prop
     * @param key
     * @return
     */
    public static String getProperty(Properties prop, String key) {
        return prop.getProperty(prop.getProperty(Constants.APP_ENV_SETTING) + key);
    }
    
    /**
     * Display the parameter and its values on debug log.
     * 
     * @param logger
     * @param parameters
     */
    public static void logSqlParameters(Logger logger, MapSqlParameterSource source) {
        if (!logger.isDebugEnabled())
            return;
        
        Map<String, Object> params = source.getValues();
        
        StringBuffer paramSB = new StringBuffer();
        paramSB.append("---------- SQL Parameter Values: ");
        
        for (String key : params.keySet()) {
            paramSB.append(key);
            paramSB.append(": ");
            
            Object o = params.get(key);
            
            paramSB.append(o);
            paramSB.append(",  ");
        }
        
        logger.debug(paramSB.toString());
    }
}
