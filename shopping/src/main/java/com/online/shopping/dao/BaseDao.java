package com.online.shopping.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.online.shopping.common.SqlManager;



public class BaseDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParaJdbcTemplate;
    
    @Autowired
    protected SqlManager sqlManager;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParaJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * @return the jdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
    /**
     * @return the namedParaJdbcTemplate
     */
    public NamedParameterJdbcTemplate getNamedParaJdbcTemplate() {
        return namedParaJdbcTemplate;
    }
    
    /**
     * @return the simpleJdbcCall
     */
    public SimpleJdbcCall getSimpleJdbcCall() {
        return new SimpleJdbcCall(jdbcTemplate);
    }
}
