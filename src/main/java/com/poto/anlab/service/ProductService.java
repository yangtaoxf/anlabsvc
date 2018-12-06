package com.poto.anlab.service;

import com.poto.anlab.model.ProductVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<ProductVO> loadAll();

    List<ProductVO> loadAllProducts();

    List<ProductVO> findByCategory(List<Integer> categoryIdList);

    List<ProductVO> findByManufacturer(List<Integer> manufacturerIdList);

    void addProduct(MultipartFile[] files, String productName, String productDesc, int categoryId, int manufacturerId);
}
