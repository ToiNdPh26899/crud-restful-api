package com.toindph26899.demo.service;

import com.toindph26899.demo.entity.Brand;
import com.toindph26899.demo.response.BrandResponse;

import java.util.List;

public interface BrandService {

    List<BrandResponse> findAll();

}
