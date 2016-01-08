package com.online.shopping.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.online.shopping.beans.User;
import com.online.shopping.beans.mapper.UserMapper;
import com.online.shopping.dao.BaseDao;
import com.online.shopping.dao.LoginDao;


@Repository
public class LoginDaoImpl extends BaseDao implements LoginDao {

	Logger logger = Logger.getLogger(LoginDaoImpl.class);	

	@Override
	public User getUserById(String uid) throws Exception {
		String sql = "select top 1 * from star_usr where usr_id = ? collate Chinese_PRC_CS_AI and registered_flag = 'Y' ";

		List<User> users = null;

		try {
			users = getJdbcTemplate().query(sql, new Object[] { uid },
					new UserMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (users == null || users.size() == 0) ? null : users.get(0);
	}
}
