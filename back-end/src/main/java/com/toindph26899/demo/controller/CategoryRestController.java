package com.toindph26899.demo.controller;

import com.toindph26899.demo.response.CategoryResponse;
import com.toindph26899.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class CategoryRestController {

    private CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categorys")
    public List<CategoryResponse> findAll() {
        return categoryService.findAll();
    }

}
