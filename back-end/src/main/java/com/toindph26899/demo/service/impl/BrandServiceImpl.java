package com.toindph26899.demo.service.impl;

import com.toindph26899.demo.entity.Brand;
import com.toindph26899.demo.repository.BrandRepository;
import com.toindph26899.demo.response.BrandResponse;
import com.toindph26899.demo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public List<BrandResponse> findAll() {

        List<Brand> findAll = brandRepository.findAll();
        List<BrandResponse> responses = new ArrayList<>();

        for (Brand brand: findAll) {
            responses.add(new BrandResponse(brand.getId(), brand.getBrandName()));
        }

        return responses;
    }
}
