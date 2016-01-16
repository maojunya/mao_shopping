package com.online.shopping.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.beans.BaseBean;
import com.online.shopping.beans.ResultMessage;
import com.online.shopping.beans.User;
import com.online.shopping.beans.Users;
import com.online.shopping.common.Constants;
import com.online.shopping.common.RespStatus;
import com.online.shopping.dao.LoginDao;
import com.online.shopping.domain.Contact;
import com.online.shopping.domain.Hobby;
import com.online.shopping.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {
	Logger logger = Logger.getLogger(LoginController.class);
	
	@Resource
	private Properties appProperties;
	
	@Resource
    private LoginService loginService; 

	@RequestMapping(method = RequestMethod.POST)
	public ResultMessage login(@RequestParam("userName") String userId,
			@RequestParam("password") String password, HttpSession session,
			HttpServletRequest request) {
		logger.info("---------- User: " + userId
				+ " access application. -----------------");

		ResultMessage rm = new ResultMessage();

		try {
			String uid = StringUtils.trimToEmpty(userId);
			
			User u = loginService.getUserById(userId);					
			rm.setCode(1);
			rm.setResult(RespStatus.SUCCESS);
			rm.setResultObject(u);
			logger.info("---------- User: " + userId
					+ " has been logined successfully. -----------------");

		} catch (Exception e) {
			rm.setResult(RespStatus.FAILED);
			rm.setMessage("Invalid to login with error code: E0001.");
			logger.error("---------- Error for user login, code is E0001", e);
		}

		return rm;
	}

	@RequestMapping(value = "/out", method = RequestMethod.GET)
	public ResultMessage loginOut(HttpSession session) {
		ResultMessage rm = new ResultMessage();
		rm.setCode(1);
		rm.setResult(RespStatus.SUCCESS);

		User u = (User) session.getAttribute(Constants.USER_SESSION);

		if (u != null) {
			logger.info("---------- User: " + u.getUserId()
					+ " has been logouted successfully.");
		} else {
			rm.setDescription("You has been logout!");
			return rm;
		}		
		session.removeAttribute(Constants.USER_SESSION);
		session.invalidate();

		rm.setDescription("You has been logout!");
		logger.debug("----------loginOut-----------");
		return rm;
	}

	@RequestMapping(value = "/{uid}", method = RequestMethod.GET)
	public ResultMessage loginValid(@PathVariable String uid) {
		logger.debug("----------loginValid-----------");
		ResultMessage rm = new ResultMessage();

		User u;
		try {
			rm.setCode(1);
			rm.setResult(RespStatus.SUCCESS);
			rm.setResultObject(null);
		} catch (Exception e) {
			rm.setResult(RespStatus.FAILED);
			logger.error(e.getMessage(), e);
		}
		logger.debug("----------loginValid-----------");
		return rm;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResultMessage registerUser(@RequestBody User newUser)
			throws Exception {
		ArrayList<HashMap<String, String>> errorList = checkObject(newUser);
		ResultMessage rm = new ResultMessage();
		
		rm.setCode(1);
		rm.setResult(RespStatus.SUCCESS);
		rm.setResultObject(errorList);
		rm.setDescription("Register Failed!");
		logger.debug("----------registerUser-----------");
		return rm;
	}
}
