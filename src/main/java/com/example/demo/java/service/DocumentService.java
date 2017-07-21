package com.example.demo.java.service;

import com.example.demo.java.model.Document;
import com.example.demo.java.model.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hyunjin on 2017-07-14.
 */
import java.util.List;

public interface DocumentService {
    public void createNewType(Type type);
    public void updateType(Type type);
    public void removeTypeById(String id);
    public List<Type> getAllDefinedTypes();
    public Type getTypeById(String id);

    public void createNewDocument(Document document);
    public void removeDocumentById(String id);
    public void updateDocument(Document document);
    public void updateLocationFromDocumentId(String documentId, String location);
}
