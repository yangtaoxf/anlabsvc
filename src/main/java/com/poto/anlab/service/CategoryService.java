package com.poto.anlab.service;

import com.poto.anlab.model.Category;
import com.poto.anlab.model.CategoryVO;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    List<CategoryVO> getAllCategoriesTree();
    void add(Category entity);
    void delete(int id);
    void update(Category entity);
}
