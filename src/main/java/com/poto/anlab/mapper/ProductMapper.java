package com.poto.anlab.mapper;

import com.poto.anlab.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    List<Product> loadAll();

    int addProduct(Product product);

    void addProductImage(int productId,String originalName,String newName,String path);

    void addProductCategory(@Param("productId") int productId,@Param("categoryId") int categoryId);

    void addProductManufacturer(@Param("productId") int productId,@Param("manufacturerId") int manufacturerId);
}
