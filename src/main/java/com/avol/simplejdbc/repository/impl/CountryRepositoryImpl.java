package com.avol.simplejdbc.repository.impl;

import com.avol.simplejdbc.domains.Country;
import com.avol.simplejdbc.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lovababu on 7/3/2015.
 */

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insertCountry() {

        //Constructor accepts data-source too.
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("COUNTRY")
                .usingGeneratedKeyColumns("ID");

        //using SimpleJdbcInsert#execute(Map<String, Object> arg)
        Map<String, Object> columnValues = new HashMap<>();
        columnValues.put("NAME", "America");
        columnValues.put("CODE", "US");

        int rows = simpleJdbcInsert.execute(columnValues);
        System.out.println("No of rows inserted By execute(2)  : " + rows);

        //using SimpleJdbcTemplate#execute(SqlParameterSouce sps)
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("NAME", "London");
        sqlParameterSource.addValue("CODE", "UK");

        rows = simpleJdbcInsert.execute(sqlParameterSource);
        System.out.println("No of rows inserted By execute(2)  : " + rows);

        //using SimpleJdbcTemplate#executeAndReturnKey(Map<String , Object> arg)
        Map<String, Object> columnValues2 = new HashMap<>();
        columnValues2.put("NAME", "Australia");
        columnValues2.put("CODE", "AU");

        Number id = simpleJdbcInsert.executeAndReturnKey(columnValues2);
        System.out.println("Record id inserted is : " + id);

        //To insert into specific columns use SimpleJdbcTemplate#usingColumns(...)
    }

    @Override
    public List<Country> countries() {
        return jdbcTemplate.query("SELECT ID as id, NAME as name, CODE as code FROM COUNTRY", new BeanPropertyRowMapper(Country.class));
    }
}
