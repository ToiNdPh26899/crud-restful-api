package com.toindph26899.demo.controller;

import com.toindph26899.demo.request.ProductRequest;
import com.toindph26899.demo.response.ProductResponse;
import com.toindph26899.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class ProductRestController {

    private ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/products")
    public List<ProductResponse> findAllCustom() {
        return productService.findAllCustom();
    }

    @PostMapping("/products")
    public void addProduct(@Valid @RequestBody ProductRequest productRequest) {
        productService.validationNumber(Double.parseDouble(productRequest.getSellPrice()),
                Double.parseDouble(productRequest.getOriginPrice()));
        productService.addProduct(productRequest);
    }

    @PutMapping("/products")
    public void updateProduct(@Valid @RequestBody ProductRequest productRequest) {
        System.out.println(productRequest);
        productService.validationNumber(Double.parseDouble(productRequest.getSellPrice()),
                Double.parseDouble(productRequest.getOriginPrice()));
        productService.updateProduct(productRequest);
    }

    @DeleteMapping("/products/{productBrandId}/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productBrandId, @PathVariable Long productId) {
        productService.deleteProduct(productBrandId, productId);
    }

    @GetMapping("/products/{productId}")
    public ProductResponse findById(@PathVariable("productId") Long productId) {
        return productService.findById(productId);
    }

    @GetMapping("/products/search")
    public List<ProductResponse> search() {
        return productService.search("quan baggy", 100.0, 1L, 2L, 1L);
    }
}
