package com.online.shopping.dao;



import javax.annotation.Resource;
import org.hibernate.SessionFactory;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class BaseHibernateDaoSupport extends HibernateDaoSupport {
	@Resource(name = "sessionFactory")
	public void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
