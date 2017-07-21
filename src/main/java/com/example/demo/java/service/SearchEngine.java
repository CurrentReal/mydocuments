package com.example.demo.java.service;

import com.example.demo.java.model.Document;
import com.example.demo.java.model.Type;

import java.util.List;

/**
 * Created by Hyunjin on 2017-07-14.
 */
public interface SearchEngine {
    public List<Document> findByType(Type documentType);
    public List<Document> listAll();
    public List<Document> findByLocation(String location);
    public Document findById(String id);
}
