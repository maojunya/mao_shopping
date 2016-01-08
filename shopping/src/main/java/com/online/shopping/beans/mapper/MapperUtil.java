package com.online.shopping.beans.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.online.shopping.beans.User;

public class MapperUtil {

	public static User getUserById(ResultSet rs, User u) throws SQLException {

		User createdU = new User();
		createdU.setUserId(rs.getString("CREATED_BY_USR_ID"));
		User updatedU = new User();
		updatedU.setUserId(rs.getString("UPDATED_BY_USR_ID"));

		return u;
	}

}
