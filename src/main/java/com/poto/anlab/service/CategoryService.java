package com.poto.anlab.service;

import com.poto.anlab.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void add(Category entity);
    void delete(int id);
    void update(Category entity);
}
