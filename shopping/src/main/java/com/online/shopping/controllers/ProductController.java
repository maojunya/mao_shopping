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
import com.online.shopping.beans.Categories;
import com.online.shopping.beans.Products;
import com.online.shopping.beans.ResultMessage;
import com.online.shopping.beans.Tx;
import com.online.shopping.beans.User;
import com.online.shopping.beans.Users;
import com.online.shopping.common.Constants;
import com.online.shopping.common.RespStatus;
import com.online.shopping.dao.LoginDao;
import com.online.shopping.dao.impl.LoginDaoImpl;
import com.online.shopping.domain.Contact;
import com.online.shopping.domain.Hobby;
import com.online.shopping.domain.Product;
import com.online.shopping.service.CategoryService;
import com.online.shopping.service.LoginService;
import com.online.shopping.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {
	Logger logger = Logger.getLogger(ProductController.class);

	@Resource
	private Properties appProperties;	

	@Resource
	private ProductService productService;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResultMessage findAll(HttpSession session) throws Exception {
		ResultMessage rm = new ResultMessage();				
		rm.setCode(1);
		rm.setResult(RespStatus.SUCCESS);
		try {
			rm.setResultObject(productService.getAllProduct());	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
			
		rm.setDescription("You get all product");
		logger.debug("----------loginOut-----------");
		return rm;
	}
	
	@RequestMapping(value = "/{ID}", method = RequestMethod.POST)
	public ResultMessage findById(HttpSession session, @PathVariable String ID) throws Exception {
		ResultMessage rm = new ResultMessage();				
		rm.setCode(1);
		rm.setResult(RespStatus.SUCCESS);
		rm.setResultObject(productService.getProductByID(ID));		
		rm.setDescription("One product selected");
		logger.debug("----------loginOut-----------");
		return rm;
	}
	
	@RequestMapping(value = "/saveOrUpdateProducts", method = RequestMethod.POST)
	public ResultMessage saveOrUpdateProducts(@RequestBody Products products) throws Exception {
		ResultMessage rm = new ResultMessage();				
		rm.setCode(1);
		rm.setResult(RespStatus.SUCCESS);
		rm.setResultObject(productService.saveProducts(products.getProducts()));
		rm.setDescription("One product selected");
		logger.debug("----------loginOut-----------");
		return rm;
	}
	
	@RequestMapping(value = "/DeleteProducts", method = RequestMethod.POST)
	public ResultMessage deleteProducts(@RequestBody Products products) throws Exception {
		ResultMessage rm = new ResultMessage();				
		rm.setCode(1);
		rm.setResult(RespStatus.SUCCESS);
		rm.setResultObject(productService.deleteProducts(products.getProducts()));
		rm.setDescription("One product selected");
		logger.debug("----------loginOut-----------");
		return rm;
	}
	
	
	@RequestMapping(value = "/saveCategories", method = RequestMethod.POST)
	public ResultMessage saveCategories(@RequestBody Categories categories) throws Exception {
		ResultMessage rm = new ResultMessage();				
		rm.setCode(1);
		rm.setResult(RespStatus.SUCCESS);
		rm.setResultObject(productService.saveCategories(categories.getCategories()));
		rm.setDescription("One product selected");
		logger.debug("----------loginOut-----------");
		return rm;
	}
	
	
	@RequestMapping(value = "/deleteCategories", method = RequestMethod.POST)
	public ResultMessage deleteCategories(@RequestBody Categories categories) throws Exception {
		ResultMessage rm = new ResultMessage();				
		rm.setCode(1);
		rm.setResult(RespStatus.SUCCESS);
		rm.setResultObject(productService.deleteCategories(categories.getCategories()));
		rm.setDescription("One product selected");
		logger.debug("----------loginOut-----------");
		return rm;
	}
	
	@RequestMapping(value = "/testTx", method = RequestMethod.POST)
	public ResultMessage testTx(@RequestBody Tx tx) throws Exception {
		ResultMessage rm = new ResultMessage();				
		rm.setCode(1);
		rm.setResult(RespStatus.SUCCESS);
		rm.setResultObject(productService.testTx(tx));
		rm.setDescription("One product selected");
		logger.debug("----------loginOut-----------");
		return rm;
	}

}
