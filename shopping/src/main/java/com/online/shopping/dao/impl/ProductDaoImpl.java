/**
 * Created on Oct 12, 2011
 */
package com.online.shopping.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.online.shopping.dao.ProductDao;
import com.online.shopping.domain.Product;

/**
 * @author Clarence
 *
 */
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	private Log log = LogFactory.getLog(ProductDaoImpl.class);
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Product> findAll() {			
		

		
		return (List<Product>)sessionFactory.getCurrentSession()
				.createSQLQuery("select * from product").addEntity(Product.class).list();
		//return products;
	}

	@Override
	public Product findByID(String ID) {
		// TODO Auto-generated method stub
		List<Product> Products = sessionFactory.getCurrentSession()
		.createSQLQuery("select * from product where productid ='"+ ID+"'")
		.addEntity(Product.class).list();
		if(Products.size() == 0){
			return null;
		}else{
			return Products.get(0);
		}		
	}
	
	@Override
	public Boolean saveProducts(List Products){		
		for(int i = 0; i < Products.size(); i++){
			
			Product p = (Product)Products.get(i);
			
			sessionFactory.getCurrentSession().save(p);
			if(i % 3 == 0 && i !=0 ){
				sessionFactory.getCurrentSession().flush();
			}
		}		
		return true;
	}

}
