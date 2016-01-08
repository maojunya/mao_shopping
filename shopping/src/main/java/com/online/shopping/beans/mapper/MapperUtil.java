package com.online.shopping.beans.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.online.shopping.beans.User;

public class MapperUtil {

	public static User getUserById(ResultSet rs, User u) throws SQLException {

		u.setUserId(rs.getString("login_account"));
        u.setFirstName(rs.getString("login_firstName"));
        u.setLastName(rs.getString("login_lastName"));
        u.setPassword(rs.getString("login_pwd"));       
        return u;
		
	}

}
