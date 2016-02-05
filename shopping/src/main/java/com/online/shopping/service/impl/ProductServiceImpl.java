package com.online.shopping.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.shopping.beans.Tx;
import com.online.shopping.dao.CategoryDao;
import com.online.shopping.dao.ProductDao;
import com.online.shopping.domain.Product;
import com.online.shopping.service.ProductService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductDao productDao;
	
	@Resource
	private CategoryDao categoryDao;

	@Override
	public List<Product> getAllProduct() throws Exception {
		// TODO Auto-generated method stub				
		return productDao.findAll();
	}
	
	@Override
	public Product getProductByID(String ID) throws Exception {
		// TODO Auto-generated method stub				
		return productDao.findByID(ID);
	}
	
	@Override
	public Boolean saveProducts(List Products) throws Exception{
		return productDao.saveProducts(Products);
	} 
	
	@Override
    public Boolean deleteProducts(List Products) throws Exception{
		return productDao.deleteProducts(Products);
	}
	
	@Override
    public Boolean saveCategories(List Categories) throws Exception{
		return categoryDao.saveCategories(Categories);
	}

	
	@Override
    public Boolean deleteCategories(List Categories) throws Exception{
		return categoryDao.deleteCategories(Categories);
	}
	
	@Override
	public Boolean testTx(Tx tx) throws Exception{
		categoryDao.saveCategories(tx.getCategories());		
		productDao.saveProducts(tx.getProducts());
		return false;
	}

}
