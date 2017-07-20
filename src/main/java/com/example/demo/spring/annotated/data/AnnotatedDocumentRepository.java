package com.example.demo.spring.annotated.data;

import com.example.demo.java.model.Document;
import com.example.demo.java.model.Type;
import com.example.demo.spring.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hyunjin on 2017-07-14.
 */

//////// Chapter 10 Error Comment
//@Repository("documentDAO")
//public class AnnotatedDocumentRepository implements DocumentDAO {
//
//    private static final String queryAll =
//            " select d.documentId, d.name, d.location, d.description as doc_desc, " +
//                    "d.typeId, d.created, d.modified, " +
//                    "t.name as type_name, t.description as type_desc, " +
//                    "t.extension from documents d join types t on d.typeId = t.typeId";
//
//    @Autowired
//    private DataSource dataSource;
//    public List<Document> getAll() {
//        List<Document> result = new ArrayList<Document>();
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        Document document = null;
//        Type type=null;
//        try {
//            connection = dataSource.getConnection();
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(queryAll);
//            while (resultSet.next()) {
//                document = new Document();
//                document.setDocumentId(resultSet.getString("documentId"));
//                document.setName(resultSet.getString("name"));
//                document.setLocation(resultSet.getString("location"));
//                document.setCreated(resultSet.getDate("created"));
//                document.setModified(resultSet.getDate("modified"));
//                document.setDescription("doc_desc");
//                type = new Type();
//                type.setTypeId(resultSet.getString("typeId"));
//                type.setName(resultSet.getString("type_name"));
//                type.setDesc(resultSet.getString("type_desc"));
//                type.setExtension(resultSet.getString("extension"));
//                document.setType(type);
//
//                result.add(document);
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        } finally {
//            if (null != connection) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                }
//            }
//        }
//        return result;
//    }

/////// before Chapter 9
//    public Document[] getAll() {
//        return storage();
//    }
//    private Document[] storage(){
//        List<Document> result = new ArrayList<Document>();
//
//        Type type = new Type();
//        type.setName("PDF");
//        type.setDesc("Portable Document Format");
//        type.setExtension(".pdf");
//
//        Document document = new Document();
//        document.setName("Book Template");
//        document.setType(type);
//        document.setLocation("/Users/felipeg/Documents/Random/Book Template.pdf");
//
//        result.add(document);
//
//        document = new Document();
//        document.setName("Sample Contract");
//        document.setType(type);
//        document.setLocation(
//                "/Users/felipeg/Documents/Contracts/Sample Contract.pdf");
//
//        result.add(document);
//
//        type = new Type();
//        type.setName("NOTE");
//        type.setDesc("Text Notes");
//        type.setExtension(".txt");
//
//        document = new Document();
//        document.setName("Clustering with RabbitMQ");
//        document.setType(type);
//        document.setLocation(
//                "/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");
//
//        result.add(document);
//
//        type = new Type();
//        type.setName("WEB");
//        type.setDesc("Web Link");
//        type.setExtension(".url");
//
//        document = new Document();
//        document.setName("Pro Spring Security Book");
//        document.setType(type);
//        document.setLocation("http://www.apress.com/9781430248187");
//
//        result.add(document);
//
//        return result.toArray(new Document[result.size()]);
//    }

//}
