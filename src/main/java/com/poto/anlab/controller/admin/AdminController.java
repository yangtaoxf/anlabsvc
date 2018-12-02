package com.poto.anlab.controller.admin;

import com.poto.anlab.model.Category;
import com.poto.anlab.model.GenericResult;
import com.poto.anlab.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private CategoryService categoryService;

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

    @RequestMapping(value = "/updateOrUpdateCategory",method = RequestMethod.POST)
    @ResponseBody
    public GenericResult updateCategory(@RequestBody  Category category) {
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

    @RequestMapping("/newProduct")
    public String newProduct() {
        return "admin/newProduct";
    }


    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    @ResponseBody
    public GenericResult teset(@RequestParam("files") MultipartFile[] files,String productName,String productDesc) {
        for (MultipartFile file: files) {
            try {
                file.transferTo(new File("d:\\a.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



}
