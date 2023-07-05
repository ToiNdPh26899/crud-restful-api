package com.toindph26899.demo.service.impl;

import com.toindph26899.demo.entity.Brand;
import com.toindph26899.demo.entity.Product;
import com.toindph26899.demo.entity.ProductBrand;
import com.toindph26899.demo.entity.Status;
import com.toindph26899.demo.entity.SubCategory;
import com.toindph26899.demo.exception.NumberException;
import com.toindph26899.demo.repository.BrandRepository;
import com.toindph26899.demo.repository.ProductBrandRepository;
import com.toindph26899.demo.repository.ProductRepository;
import com.toindph26899.demo.repository.StatusRepository;
import com.toindph26899.demo.repository.SubCategoryRepository;
import com.toindph26899.demo.request.ProductRequest;
import com.toindph26899.demo.response.ProductResponse;
import com.toindph26899.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductBrandRepository productBrandRepository;
    private SubCategoryRepository subCategoryRepository;
    private BrandRepository brandRepository;
    private StatusRepository statusRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductBrandRepository productBrandRepository,
                              SubCategoryRepository subCategoryRepository,
                              BrandRepository brandRepository,
                              StatusRepository statusRepository) {
        this.productRepository = productRepository;
        this.productBrandRepository = productBrandRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.brandRepository = brandRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public List<ProductResponse> findAllCustom() {

        List<ProductBrand> findAll = productBrandRepository.findAll();

        List<ProductResponse> findAllCustom = new ArrayList<>();

        for (ProductBrand p : findAll) {
            findAllCustom.add(ProductResponse.builder()
                    .id(p.getId())
                    .productId(p.getProductId().getId())
                    .productName(p.getProductId().getProductName())
                    .brandName(p.getBrandId().getBrandName())
                    .subCategoryName(p.getProductId().getSubCategoryId().getSubCateName())
                    .sellPrice(p.getProductId().getSellPrice())
                    .statusId(p.getProductId().getStatusId().getId())
                    .statusName(p.getProductId().getStatusId().getStatusName())
                    .build());
        }

        return findAllCustom;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductResponse findById(Long id) {

        Optional<ProductBrand> productBrandResult = productBrandRepository.findById(id);
        ProductResponse productResponse = null;

        if (productBrandResult.isPresent()) {
            productResponse = ProductResponse.builder()
                    .id(productBrandResult.get().getId())
                    .productId(productBrandResult.get().getProductId().getId())
                    .brandId(productBrandResult.get().getBrandId().getId())
                    .subCategoryId(productBrandResult.get().getProductId().getSubCategoryId().getId())
                    .productName(productBrandResult.get().getProductId().getProductName())
                    .color(productBrandResult.get().getProductId().getColor())
                    .quantity(productBrandResult.get().getProductId().getQuantity())
                    .sellPrice(productBrandResult.get().getProductId().getSellPrice())
                    .originPrice(productBrandResult.get().getProductId().getOriginPrice())
                    .brandName(productBrandResult.get().getBrandId().getBrandName())
                    .subCategoryName(productBrandResult.get().getProductId().getSubCategoryId().getSubCateName())
                    .statusId(productBrandResult.get().getProductId().getStatusId().getId())
                    .build();
        } else {
            throw new RuntimeException("Not found id - " + id);
        }

        return productResponse;
    }

    @Override
    public void addProduct(ProductRequest productRequest) {

        if (productRequest.getSubCategoryId() == null || productRequest.getBrandId() == null) {
            return;
        }

        Optional<SubCategory> result = subCategoryRepository.findById(productRequest.getSubCategoryId());
        Optional<Brand> resultBrand = brandRepository.findById(productRequest.getBrandId());
        Optional<Status> resultStatus = statusRepository.findById(1l);

        Brand brand = null;
        SubCategory subCategory = null;
        Status status = null;

        if (result.isPresent() && resultBrand.isPresent() && resultStatus.isPresent()) {
            subCategory = result.get();
            brand = resultBrand.get();
            status = resultStatus.get();
        } else {
            return;
        }

        Product product = Product.builder()
                .id(productRequest.getProductId())
                .productName(productRequest.getProductName())
                .color(productRequest.getColor())
                .quantity(Long.valueOf(productRequest.getQuantity()))
                .sellPrice(Double.valueOf(productRequest.getSellPrice()))
                .originPrice(Double.valueOf(productRequest.getOriginPrice()))
                .statusId(status)
                .subCategoryId(subCategory)
                .build();


        Product dbProduct = productRepository.save(product);

        ProductBrand productBrand = ProductBrand.builder()
                .productId(dbProduct)
                .brandId(brand)
                .build();

        productBrandRepository.save(productBrand);
    }

    @Override
    public void updateProduct(ProductRequest productRequest) {

        Optional<SubCategory> result = subCategoryRepository.findById(productRequest.getSubCategoryId());
        Optional<Brand> resultBrand = brandRepository.findById(productRequest.getBrandId());
        Optional<Status> resultStatus = statusRepository.findById(productRequest.getStatusId());

        Brand brand = null;
        SubCategory subCategory = null;
        Status status = null;

        if (result.isPresent() && resultBrand.isPresent() && resultStatus.isPresent()) {
            subCategory = result.get();
            brand = resultBrand.get();
            status = resultStatus.get();
        } else {
            return;
        }

        Product product = Product.builder()
                .id(productRequest.getProductId())
                .productName(productRequest.getProductName())
                .color(productRequest.getColor())
                .quantity(Long.parseLong(productRequest.getQuantity()))
                .sellPrice(Double.parseDouble(productRequest.getSellPrice()))
                .originPrice(Double.parseDouble(productRequest.getOriginPrice()))
                .statusId(status)
                .subCategoryId(subCategory)
                .build();

        productRepository.save(product);

        ProductBrand productBrand = ProductBrand.builder()
                .id(productRequest.getProductBrandId())
                .productId(product)
                .brandId(brand)
                .build();

        productBrandRepository.save(productBrand);

    }

    @Override
    public void deleteProduct(Long productBrandId, Long productId) {
        Optional<ProductBrand> resultProductBrand = productBrandRepository.findById(productBrandId);

        ProductBrand productBrand = null;

        if (resultProductBrand.isPresent()) {
            productBrand = resultProductBrand.get();
        } else {
            throw new RuntimeException("Not found");
        }
        productBrandRepository.delete(productBrand);
        productRepository.deleteById(productId);
    }

    @Override
    public Boolean validationNumber(Double sellPrice, Double originPrice) {

        if (sellPrice > originPrice) {
            return true;
        } else {
            throw new NumberException("Sell price phai lon hon price");
        }
    }

    @Override
    public List<ProductResponse> search(String name, Double price, Long brandId, Long cateId, Long statusId) {
        return productRepository.search(name, price, brandId, cateId, statusId);
    }
}
