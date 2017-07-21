package com.example.demo.java.service;

import com.example.demo.java.model.Document;

import java.util.List;

/**
 * Created by Hyunjin on 2017-07-21.
 */
public interface DocumentService {
    public List<Document> getAllDocuments();
    public Document findDocumentById(String id);
    public Document saveDocument(String id, Document document);
    public Document removeDocumentById(String id);
    public boolean updateLocationFromDocumentId(String documentId, String location);
}
