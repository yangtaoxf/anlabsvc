package com.poto.anlab.controller.admin;

import com.poto.anlab.model.Category;
import com.poto.anlab.model.GenericResult;
import com.poto.anlab.model.Manufacturer;
import com.poto.anlab.model.ProductVO;
import com.poto.anlab.service.CategoryService;
import com.poto.anlab.service.ManufacturerService;
import com.poto.anlab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping("/index")
    public String greeting() {
        return "admin/hello";
    }

    @RequestMapping("/editTable")
    public String editTable() {
        return "admin/basicTable";
    }

    @RequestMapping("/allCategory")
    public String allCategory(Model model) {
        List<Category> categoryList = categoryService.getAllCategories();
        model.addAttribute("categories",categoryList);
        model.addAttribute("name","myName");
        return "admin/allCategory";
    }

    @RequestMapping(value = "/andOrUpdateCategory",method = RequestMethod.POST)
    @ResponseBody
    public GenericResult andOrUpdateCategory(@RequestBody  Category category) {
        if(category.getId() == 0){
            categoryService.add(category);
        }else{
            categoryService.update(category);
        }
        return GenericResult.getSuccess();
    }

    @RequestMapping(value = "/deleteCategory",method = RequestMethod.GET)
    @ResponseBody
    public GenericResult deleteCategory(@RequestParam("id") int id) {
        categoryService.delete(id);
        return GenericResult.getSuccess();
    }


    @RequestMapping("/allManufacturer")
    public String allManufacturer(Model model) {
        List<Manufacturer> categoryList = manufacturerService.getAll();
        model.addAttribute("manufacturers",categoryList);
        return "admin/allManufacturer";
    }

    @RequestMapping(value = "/andOrUpdateManufacturer",method = RequestMethod.POST)
    @ResponseBody
    public GenericResult andOrUpdateManufacturer(@RequestBody  Manufacturer manufacturer) {
        if(manufacturer.getId() == 0){
            manufacturerService.add(manufacturer);
        }else{
            manufacturerService.update(manufacturer);
        }
        return GenericResult.getSuccess();
    }

    @RequestMapping(value = "/deleteManufacturer",method = RequestMethod.GET)
    @ResponseBody
    public GenericResult deleteManufacturer(@RequestParam("id") int id) {
        manufacturerService.delete(id);
        return GenericResult.getSuccess();
    }


    @RequestMapping("/newProduct")
    public String newProduct(Model model) {
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        List<Category> categoryList = categoryService.getAllCategories();
        model.addAttribute("categories",categoryList);
        model.addAttribute("manufacturers",manufacturerList);
        return "admin/newProduct";
    }


    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    @ResponseBody
    public GenericResult addProduct(@RequestParam("files") MultipartFile[] files,String productName,String productDesc,int categoryId,int manufacturerId) {
        productService.addProduct(files,productName,productDesc,categoryId,manufacturerId);
        return GenericResult.getSuccess();
    }

    @RequestMapping(value = "/allProducts",method = RequestMethod.GET)
    @ResponseBody
    public GenericResult allProducts() {
        List<ProductVO> allProducts = productService.loadAllProducts();
        return GenericResult.getSuccess();
    }

}
