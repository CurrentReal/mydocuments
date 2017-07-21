package com.example.demo.spring.service;

import com.example.demo.java.model.Document;
import com.example.demo.java.model.Type;
import com.example.demo.java.service.SearchEngine;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Hyunjin on 2017-07-17.
 */
@Component
@Profile("qa")
public class FileSearchEngineService implements SearchEngine {

    public List<Document> findByType(Type documentType) {
        throw new UnsupportedOperationException(
                "QA Environment. Not yet implemented operation.");
    }

    public List<Document> listAll() {
        throw new UnsupportedOperationException(
                "QA Environment. Not yet implemented operation.");
    }

    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException("findByLocation not yet implemented.");
    }

    @Override
    public Document findById(String id) {
        return null;
    }
}
