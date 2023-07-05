package com.toindph26899.demo.service.impl;

import com.toindph26899.demo.entity.SubCategory;
import com.toindph26899.demo.repository.SubCategoryRepository;
import com.toindph26899.demo.response.SubCategoryResponse;
import com.toindph26899.demo.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public List<SubCategoryResponse> findAll() {

        List<SubCategory> findAll = subCategoryRepository.findAll();
        List<SubCategoryResponse> subCategoryResponses = new ArrayList<>();

        for(SubCategory subCategory: findAll) {
            subCategoryResponses.add(new SubCategoryResponse(subCategory.getId(),
                    subCategory.getSubCateName()));
        }

        return subCategoryResponses;
    }
}
