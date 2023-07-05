package com.toindph26899.demo.service;

import com.toindph26899.demo.entity.Product;
import com.toindph26899.demo.exception.NumberException;
import com.toindph26899.demo.request.ProductRequest;
import com.toindph26899.demo.response.ProductResponse;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ProductService {

    List<ProductResponse> findAllCustom();

    List<Product> findAll();

    ProductResponse findById(Long id);

    void addProduct(ProductRequest productRequest);

    void updateProduct(ProductRequest productRequest);

    void deleteProduct(Long productBrandId, Long productId);

    Boolean validationNumber(Double sellPrice, Double originPrice);

    List<ProductResponse> search(String name, Double price, Long brandId, Long cateId, Long statusId);

}
