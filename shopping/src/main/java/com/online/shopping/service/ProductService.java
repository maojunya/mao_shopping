
package com.online.shopping.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.online.shopping.beans.Tx;
import com.online.shopping.beans.User;
import com.online.shopping.domain.Contact;
import com.online.shopping.domain.Product;


public interface ProductService {
    /**
     *  Get user with its id, this id is added by DBA.
     */
    public List<Product> getAllProduct() throws Exception;  
    
    public Product getProductByID(String ID) throws Exception;  
    
    public Boolean saveProducts(List Products) throws Exception; 
    
    public Boolean deleteProducts(List Products) throws Exception; 
    
    public Boolean saveCategories(List categories) throws Exception; 
    
    public Boolean deleteCategories(List Categories) throws Exception;
    
    public Boolean testTx(Tx tx) throws Exception;   

}
