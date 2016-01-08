
package com.online.shopping.beans.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.online.shopping.beans.User;

public class UserMapper implements RowMapper<User> {

    /* (non-Javadoc)
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        return MapperUtil.getUserById(rs, new User());
    }

}
