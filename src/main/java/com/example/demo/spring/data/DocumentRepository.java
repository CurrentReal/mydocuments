package com.example.demo.spring.data;

import com.example.demo.java.model.Document;
import com.example.demo.java.model.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hyunjin on 2017-07-14.
 */
@Repository("documentDAO")
public class DocumentRepository implements DocumentDAO {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private String query;
    @Autowired
    private String insert;
    @Autowired
    private String find;
    @Autowired
    private String update;

    public List<Document> getAll() {
        return new JdbcTemplate(dataSource).query(query, new DocumentRowMapper());
    }

    public Document findById(String id) {
        Document updateDocument = null;
        JdbcTemplate template = new JdbcTemplate(dataSource);

        try {
            updateDocument = template.queryForObject(find,
                    new Object[] { id },
                    new DocumentRowMapper());
        } catch (EmptyResultDataAccessException ex) {}
        return updateDocument;
    }

    public void save(Document document) {
        try {
            JdbcTemplate template = new JdbcTemplate(dataSource);
            if (null == findById(document.getDocumentId()))
                template.update(
                        insert,
                        new Object[] { document.getDocumentId(),
                                document.getName(), document.getLocation(),
                                document.getDescription(),
                                document.getType().getTypeId(),
                                document.getCreated(), document.getModified() });
            else
                template.update(
                        update,
                        new Object[] { document.getName(),
                                document.getLocation(),
                                document.getDescription(),
                                document.getType().getTypeId(), new Date(),
                                document.getDocumentId() });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
