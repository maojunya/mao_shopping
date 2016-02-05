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
public interface CategoryDao {

	public Boolean saveCategories(List Categories);
	
	public Boolean deleteCategories(List Categories);
	
	
}
