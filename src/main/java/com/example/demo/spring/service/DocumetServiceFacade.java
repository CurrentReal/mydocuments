package com.example.demo.spring.service;

import com.example.demo.java.model.Document;
import com.example.demo.java.service.DocumentService;
import com.example.demo.spring.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Hyunjin on 2017-07-21.
 */
@Component("documentFacade")
public class DocumetServiceFacade implements DocumentService {

    @Autowired
    DocumentDAO documentDAO;

    public List<Document> getAllDocuments() {
        return documentDAO.getAll();
    }

    public Document saveDocument(String id, Document document) {
        return documentDAO.save(id, document);
    }

    public Document removeDocumentById(String id) {
        return documentDAO.removeById(id);
    }

    public Document findDocumentById(String id){
        return documentDAO.findById(id);
    }

    public boolean updateLocationFromDocumentId(String documentId, String location) {
        Document document = documentDAO.findById(documentId);
        if(null == document)
            return false;
        document.setLocation(location);
        saveDocument(documentId, document);
        return true;
    }

}
