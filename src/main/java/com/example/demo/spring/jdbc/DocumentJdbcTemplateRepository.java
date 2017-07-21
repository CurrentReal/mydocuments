package com.example.demo.spring.jdbc;

import com.example.demo.java.model.Document;
import com.example.demo.spring.data.DocumentDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Hyunjin on 2017-07-20.
 */
public class DocumentJdbcTemplateRepository implements DocumentDAO {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private String query;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public void setQuery(String query){
        this.query = query;
    }

    public List<Document> getAll() {
        return jdbcTemplate.query(query, new DocumentRowMapper());
    }

    public void save(Document document) { }

    @Override
    public Document findById(String id) {
        return null;
    }
}
