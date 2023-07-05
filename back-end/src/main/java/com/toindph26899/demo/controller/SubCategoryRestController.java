package com.toindph26899.demo.controller;

import com.toindph26899.demo.response.SubCategoryResponse;
import com.toindph26899.demo.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class SubCategoryRestController {

    private SubCategoryService subCategoryService;

    @Autowired
    public SubCategoryRestController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/subCategorys")
    public List<SubCategoryResponse> findAll() {
        return subCategoryService.findAll();
    }
}
