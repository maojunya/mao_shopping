package com.online.shopping.dao.impl;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.online.shopping.beans.User;
import com.online.shopping.beans.mapper.UserMapper;
import com.online.shopping.dao.BaseDao;
import com.online.shopping.dao.LoginDao;


@Repository
public class LoginDaoImpl extends BaseDao implements LoginDao {

	Logger logger = Logger.getLogger(LoginDaoImpl.class);	

	@Override
	public User getUserById(HashMap<String, String> hs) throws Exception {
		String sql = "select * from t_login where login_account = ? and login_pwd = ?;";

		List<User> users = null;		
		try {
			users = getJdbcTemplate().query(sql, new Object[] { hs.get("userName"), hs.get("password")},
					new UserMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (users == null || users.size() == 0) ? null : users.get(0);
	}
}
