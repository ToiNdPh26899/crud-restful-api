package com.toindph26899.demo.service;

import com.toindph26899.demo.entity.Category;
import com.toindph26899.demo.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> findAll();

}
