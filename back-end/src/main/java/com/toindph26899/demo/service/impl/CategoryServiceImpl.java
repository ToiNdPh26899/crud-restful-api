package com.toindph26899.demo.service.impl;

import com.toindph26899.demo.entity.Category;
import com.toindph26899.demo.repository.CategoryRepository;
import com.toindph26899.demo.response.CategoryResponse;
import com.toindph26899.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponse> findAll() {

        List<CategoryResponse> listHienThi = new ArrayList<>();
        List<Category> findAll = categoryRepository.findAll();

        for (Category category: findAll) {
            listHienThi.add(new CategoryResponse(category.getId(), category.getCateName()));
        }

        return listHienThi;
    }
}
