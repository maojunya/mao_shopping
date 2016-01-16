package com.online.shopping.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.online.shopping.beans.BaseBean;
import com.online.shopping.beans.ResultMessage;
import com.online.shopping.common.RespStatus;
import com.online.shopping.common.StarException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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

	protected ArrayList<HashMap<String, String>> checkObject(BaseBean bb) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();		
		Set<ConstraintViolation<BaseBean>> constraintViolations =  validator.validate( bb );				
		Iterator<ConstraintViolation<BaseBean>> it = constraintViolations.iterator();		
		ArrayList<HashMap<String, String>> errorList = new ArrayList<HashMap<String, String>>();
		
		while(it.hasNext()){			
			ConstraintViolation<BaseBean> cv = it.next();	
			HashMap<String, String> error = new HashMap<String, String>();
			error.put(cv.getPropertyPath().toString(), cv.getMessage());
			errorList.add(error);
		}
		return errorList;
	}

}
