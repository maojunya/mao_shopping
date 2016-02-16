/**
 *  PWC
 */
package com.online.shopping.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.online.shopping.beans.ResultMessage;
import com.online.shopping.beans.User;


/**
 * @author Tomas Hu Chuanjiang
 * @email tomas.hu@outlook.com
 * @date Aug 25, 2014
 *
 */
public class AuthenticationFilter implements Filter {
    
    //private ServletContext context;
    private String[] excludeUrls = {};
    private String[] excludePages = {};
    
    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        this.excludeUrls = null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setContentType("application/json");
        response.setHeader("Pragma","No-cache"); 
        response.setHeader("Cache-Control","no-cache"); 
        response.setDateHeader("Expires", 0);
        
        String currentURI = request.getRequestURI();
        boolean needBeChecked = false;
        for(String url : excludeUrls){
        	if(!currentURI.endsWith(url)){
        		needBeChecked = true;
        	}
        }
        
        if(needBeChecked){
        	User user = (User)request.getSession().getAttribute(Constants.USER_SESSION);
            if(user !=null){
            	// do nothing
            }else{
            	ResultMessage result = new ResultMessage();
            	result.setDescription("This messge was provided by authetication filter.");                
                response.getWriter().println(result);                
                return;
            }        	
        }
        
        chain.doFilter(req, resp);
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig fconfig) throws ServletException {
        String pages = fconfig.getInitParameter("excludePages");
        String urls = fconfig.getInitParameter("excludeUrls");
        
        if (pages != null)
            this.excludePages = pages.split(Constants.SEPARATOR_SEMICOLON);
        
        if (urls != null) 
            this.excludeUrls = urls.split(Constants.SEPARATOR_SEMICOLON); 
        
    }

}
