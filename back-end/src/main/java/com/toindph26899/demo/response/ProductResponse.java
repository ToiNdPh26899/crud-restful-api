package com.toindph26899.demo.response;

import jakarta.validation.constraints.NotNull;
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
public class ProductResponse {

    private Long id;

    private Long brandId;

    private Long productId;

    private Long subCategoryId;

    private Long statusId;

    private String productName;

    private String brandName;

    private String subCategoryName;

    private Double sellPrice;

    private Double originPrice;

    private Long quantity;

    private String color;

    private String statusName;
}
