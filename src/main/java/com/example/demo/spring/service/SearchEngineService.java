package com.example.demo.spring.service;

import com.example.demo.java.model.Document;
import com.example.demo.java.model.Type;
import com.example.demo.java.service.SearchEngine;
import com.example.demo.spring.data.DocumentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hyunjin on 2017-07-14.
 */
//public class SearchEngineService implements SearchEngine {
//
//    private static final Logger log = LoggerFactory.getLogger(SearchEngineService.class);
//    private DocumentDAO documentDAO;
//
//    public SearchEngineService() {
//        if (log.isDebugEnabled())
//            log.debug("SearchEngineService created: " + this);
//    }
//
//    public DocumentDAO getDocumentDAO() {
//        return documentDAO;
//    }
//
//    public void setDocumentDAO(DocumentDAO documentDAO) {
//        if (log.isDebugEnabled())
//            log.debug("Document DAO set: " + documentDAO);
//
//        this.documentDAO = documentDAO;
//    }
//
//    public List<Document> findByType(Type documentType) {
//        List<Document> result = new ArrayList<Document>();
//        for (Document doc : listAll()) {
//            if (doc.getType().getName().equals(documentType.getName()))
//                result.add(doc);
//        }
//        return result;
//    }
//
//    public List<Document> listAll() {
//        return Arrays.asList(documentDAO.getAll());
//    }
//
//}

public class SearchEngineService implements SearchEngine {

    private DocumentDAO documentDAO;

    public SearchEngineService() {
    }

    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public List<Document> findByType(Type documentType) {
        List<Document>  result = new ArrayList<Document>();
        for (Document doc : listAll()) {
            if (doc.getType().getName().equals(documentType.getName()))
                result.add(doc);
        }
        return result;
    }

    public List<Document> listAll() {
        List<Document> result = documentDAO.getAll();
        ////////// before Chapter 9
//        List<Document> result = Arrays.asList(documentDAO.getAll());
        return result;
    }

    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException("findByLocation not yet implemented.");
    }

}

