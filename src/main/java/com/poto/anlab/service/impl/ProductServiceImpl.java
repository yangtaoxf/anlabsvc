package com.poto.anlab.service.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.poto.anlab.mapper.ProductMapper;
import com.poto.anlab.model.Product;
import com.poto.anlab.model.ProductImageVO;
import com.poto.anlab.model.ProductVO;
import com.poto.anlab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    private static final String ALL_KEY = "all";
    private static final String IMG_PATH = "d:\\";

    LoadingCache<String, List<ProductVO>> cacheLoader =
            CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS)
                    .build(new CacheLoader<String, List<ProductVO>>() {
                        @Override
                        public List<ProductVO> load(String s) throws Exception {
                            return loadAllProducts();
                        }
                    });




    @Override
    public List<ProductVO> loadAll(){
        try {
            return cacheLoader.get("ALL_KEY");
        } catch (ExecutionException e) {
            e.printStackTrace();
            return Lists.newArrayList();
        }
    }

    @Override
    public List<ProductVO> loadAllProducts(){
       List<Product> allProducts = productMapper.loadAll();
       List<ProductVO> productVOList = new ArrayList<>();

       Map<Integer,List<Product>> groupedProducts = allProducts.stream().collect(Collectors.groupingBy(Product::getProductId));
       groupedProducts.keySet().forEach(productId ->{
           List<Product> products = groupedProducts.get(productId);
           ProductVO productVO = new ProductVO();
           List<ProductImageVO> imageVOS = Lists.newArrayList();
           products.forEach(product -> {
               ProductImageVO imageVO = new ProductImageVO();
               imageVO.setImageNewName(product.getImageNewName());
               imageVO.setImageOriginName(product.getImageOriginName());
               imageVO.setImagePath(product.getImagePath());
               imageVOS.add(imageVO);
           });

           Product product = products.get(0);

           productVO.setProductId(product.getProductId());
           productVO.setProductName(product.getProductName());
           productVO.setProductDesc(product.getProductDesc());
           productVO.setCategoryCnName(product.getCategoryCnName());
           productVO.setCategoryEnName(product.getCategoryEnName());
           productVO.setCategoryId(product.getCategoryId());
           productVO.setManufacturerId(product.getManufacturerId());
           productVO.setManufacturerCnName(product.getManufacturerCnName());
           productVO.setManufacturerEnName(product.getManufacturerEnName());
           productVO.setProductImageVOList(imageVOS);

           productVOList.add(productVO);

       });
       return productVOList;
    }



    @Override
    public List<ProductVO> findByCategory(List<Integer> categoryIdList){
        return loadAll().stream().filter(productVO -> categoryIdList.contains(productVO.getCategoryId())).collect(Collectors.toList());
    }

    @Override
    public List<ProductVO> findByManufacturer(List<Integer> manufacturerIdList){
        return loadAll().stream().filter(productVO -> manufacturerIdList.contains(productVO.getManufacturerId())).collect(Collectors.toList());
    }




    @Override
    @Transactional
    public void addProduct(MultipartFile[] files, String productName, String productDesc, int categoryId, int manufacturerId){
        Product product = new Product();
        product.setProductName(productName);
        product.setProductDesc(productDesc);

        productMapper.addProduct(product);
        int productId =  product.getProductId();
        for (MultipartFile file: files) {
                try {
                    String newFileName = productId + "_" + System.currentTimeMillis()+"_"+file.getName()+"_"+file.getOriginalFilename();
                    String path = IMG_PATH + newFileName;
                    file.transferTo(new File(path));
                    productMapper.addProductImage(productId,file.getOriginalFilename(),newFileName,path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        productMapper.addProductCategory(productId,categoryId);
        productMapper.addProductManufacturer(productId,manufacturerId);
    }



}
