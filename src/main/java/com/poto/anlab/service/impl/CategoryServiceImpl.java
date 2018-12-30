package com.poto.anlab.service.impl;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.Lists;
import com.poto.anlab.mapper.CategoryMapper;
import com.poto.anlab.model.Category;
import com.poto.anlab.model.CategoryVO;
import com.poto.anlab.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Service
public class CategoryServiceImpl implements CategoryService {

    public static final int CATEGORY_LEVEL_1 = 1;
    public static final int CATEGORY_LEVEL_2 = 2;
    public static final int CATEGORY_LEVEL_3 = 3;

    private final static Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryMapper categoryMapper;


    Supplier<List<Category>> allCategories = Suppliers.memoizeWithExpiration(() -> loadAllCategories(), 5000, MILLISECONDS);
    Supplier<List<CategoryVO>> allCategoriesTree = Suppliers.memoizeWithExpiration(() -> loadAllCategoriesTree(), 5000, MILLISECONDS);

    private List<Category> loadAllCategories(){
        List<Category> categories = categoryMapper.getAllCategories();
        logger.info("loaded all categories from database, size is " + categories.size() );
        return categories;
    }

    private List<CategoryVO> loadAllCategoriesTree(){
        List<Category> categories = allCategories.get();

        List<Category> level1 = categories.stream().filter(item -> item.getNodeLevel() == CATEGORY_LEVEL_1).collect(Collectors.toList());
        List<Category> level2 = categories.stream().filter(item -> item.getNodeLevel() == CATEGORY_LEVEL_2).collect(Collectors.toList());
        List<Category> level3 = categories.stream().filter(item -> item.getNodeLevel() == CATEGORY_LEVEL_3).collect(Collectors.toList());

        Map<String,List<Category>> level3Map = level3.stream().collect(Collectors.groupingBy(Category::getParentNode,Collectors.toList()));
        Map<String,List<Category>> level2Map = level2.stream().collect(Collectors.groupingBy(Category::getParentNode,Collectors.toList()));

        List<CategoryVO> level1VOs = Lists.newArrayList();

        level1.forEach(item ->{
            CategoryVO vo = item.getVO();
            vo.setSubCategoryVOList(level2Map.get(vo.getNodeId()).stream().map(item2 -> item2.getVO()).collect(Collectors.toList()));
            vo.getSubCategoryVOList().forEach(level2VO ->{
                List<Category> level3s = level3Map.get(level2VO.getNodeId());
                if(!CollectionUtils.isEmpty(level3s)){
                    level2VO.setSubCategoryVOList(level3s.stream().map(item3->item3.getVO()).collect(Collectors.toList()));
                }

            });
            level1VOs.add(vo);
        });
        logger.info("loaded all categories tree " + categories );
        return level1VOs;
    }

    public List<Category> getAllCategories(){
       return allCategories.get();
    }
    public List<CategoryVO> getAllCategoriesTree(){
        return allCategoriesTree.get();
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
