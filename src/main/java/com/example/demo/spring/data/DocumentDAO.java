package com.example.demo.spring.data;

import com.example.demo.java.model.Document;

import java.util.List;

/**
 * Created by Hyunjin on 2017-07-14.
 */
public interface DocumentDAO {
    public List<Document> getAll();
    public Document save(String id, Document document);
    public Document findById(String id);
    public Document removeById(String id);
}
