package com.example.demo.spring.annotated.service;

import com.example.demo.java.model.Document;
import com.example.demo.java.model.Type;
import com.example.demo.java.service.SearchEngine;
import com.example.demo.spring.data.DocumentDAO;

import com.example.demo.spring.service.SearchEngineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hyunjin on 2017-07-14.
 */
@Service("engine")
@Scope("prototype")
public class AnnotatedSearchEngine implements SearchEngine {

    private static final Logger log =
            LoggerFactory.getLogger(SearchEngineService.class);

    @Autowired
    private DocumentDAO documentDAO;

    public AnnotatedSearchEngine() {
        if (log.isDebugEnabled())
            log.debug("AnnotatedSearchEngine created: " + this);
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
        return Arrays.asList(documentDAO.getAll());
    }

    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException("findByLocation not yet implemented.");
    }
}
