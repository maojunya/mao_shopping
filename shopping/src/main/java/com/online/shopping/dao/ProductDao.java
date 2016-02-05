/**
 * Created on Oct 12, 2011
 */
package com.online.shopping.dao;

import java.util.HashMap;
import java.util.List;

import com.online.shopping.domain.Contact;
import com.online.shopping.domain.Product;


/**
 * @author Clarence
 *
 */
public interface ProductDao {

	// Find all contacts
	public List<Product> findAll();	
	
	public Product findByID(String ID);	
	
	public Boolean saveProducts(List Products);
	
	public Boolean deleteProducts(List Products);
	
	
}
