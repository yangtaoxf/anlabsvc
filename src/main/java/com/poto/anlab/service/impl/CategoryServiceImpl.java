package com.poto.anlab.service.impl;

import com.poto.anlab.mapper.CategoryMapper;
import com.poto.anlab.model.Category;
import com.poto.anlab.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    public List<Category> getAllCategories(){
       return categoryMapper.getAllCategories();
    }
    public void add(Category entity){
        categoryMapper.add(entity);
    }
    public void delete(int id){
        categoryMapper.delete(id);
    }
    public void update(Category entity){
        categoryMapper.update(entity);
    }

}
