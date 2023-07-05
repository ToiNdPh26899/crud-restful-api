package com.toindph26899.demo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductRequest {

    private Long productBrandId;

    private Long productId;

    @NotBlank(message = "Product name Khong được bỏ trống")
    @Size(max = 100, message = "Product name khong duoc vuot qua 100 ki tu")
    private String productName;

    @NotBlank(message = "Color Khong được bỏ trống")
    @Size(max = 50, message = "Color khong duoc vuot qua 50 ki tu")
    private String color;

    @NotBlank(message = "Quantity Khong được bỏ trống")
    @Pattern(regexp = "[0-9]+", message = "Sai dinh dang quantity la so nguyen duong")
    private String quantity;

    @NotBlank(message = "Sell price Khong được bỏ trống")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]+)?$", message = "Sai dinh dang")
    private String sellPrice;

    @NotBlank(message = "Origin Price Khong được bỏ trống")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]+)?$", message = "Sai dinh dang")
    private String originPrice;

    @NotNull(message = "BrandId Khong được bỏ trống")
    private Long brandId;

    @NotNull(message = "SubCategory Khong được bỏ trống")
    private Long subCategoryId;

    private Long statusId;

}
