
package com.online.shopping.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**

 *
 * A singleton class is designed to store data that will be used in entire application
 */
@Component
@Scope("singleton")
public class DataModel {
    
    @Resource
    private Properties appProperties;
    
    private Map<String, String> domsList = new HashMap<>();
  
    public void addDom(String key, String dom) {
        domsList.put(key, dom);
    }
    
    public String getDom(String key) {
        String v = domsList.get(key);
        
        //clear it after we used it and for local no need to clear memory.
        if (!Constants.APP_ENV_LOCAL.equals(appProperties.get(Constants.APP_ENV_SETTING)))
            domsList.remove(key);
        
        return v;
    }
}
