package com.example.demo.spring.data;

import com.example.demo.java.model.Type;

/**
 * Created by Hyunjin on 2017-07-15.
 */
public interface TypeDataDAO {
    public Type[] getAll();
    public Type findById(String id);
}
