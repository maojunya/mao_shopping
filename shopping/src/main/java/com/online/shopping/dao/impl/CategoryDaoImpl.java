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

import com.online.shopping.dao.CategoryDao;
import com.online.shopping.dao.ProductDao;
import com.online.shopping.domain.Category;
import com.online.shopping.domain.Product;

/**
 * @author Clarence
 *
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	private Log log = LogFactory.getLog(CategoryDaoImpl.class);
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Boolean saveCategories(List Categories) {
		for (int i = 0; i < Categories.size(); i++) {
			Category c = (Category) Categories.get(i);
			sessionFactory.getCurrentSession().saveOrUpdate(c);
			if (i % 3 == 0 && i != 0) {
				sessionFactory.getCurrentSession().flush();
			}
		}
		return true;
	}

	@Override
	public Boolean deleteCategories(List Categories) {
		
		for (int i = 0; i < Categories.size(); i++) {
			Category p = (Category) Categories.get(i);
			sessionFactory.getCurrentSession().delete(p);
			if (i % 3 == 0 && i != 0) {
				sessionFactory.getCurrentSession().flush();
			}
		}
		return true;
	}

}
