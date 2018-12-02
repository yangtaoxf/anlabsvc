package com.poto.anlab.mapper;

import com.poto.anlab.model.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> getAllCategories();
    void add(Category entity);
    void delete(int id);
    void update(Category entity);
}
