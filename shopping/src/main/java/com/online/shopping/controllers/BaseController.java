package com.online.shopping.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.online.shopping.beans.ResultMessage;
import com.online.shopping.common.RespStatus;
import com.online.shopping.common.StarException;

public class BaseController {

    protected Logger logger = Logger.getLogger(getClass());
    
	@ExceptionHandler(StarException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResultMessage handleCustomException(StarException ex) {
	    ResultMessage rm = new ResultMessage();
	    rm.setResult(RespStatus.FAILED);
	    rm.setMessage(ex.getMessage());
		
		return rm;
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResultMessage handleException(Exception ex) {
	    ResultMessage rm = new ResultMessage();
        rm.setResult(RespStatus.FAILED);
        rm.setMessage("System error occured, please contact system administrator!");
		
		return rm;
	}
}
