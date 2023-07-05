package com.toindph26899.demo.repository;

import com.toindph26899.demo.entity.Product;
import com.toindph26899.demo.response.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select new com.toindph26899.demo.response.ProductResponse(pb.id, " +
            "pb.brandId.id, pb.productId.id, pb.productId.subCategoryId.id, " +
            "pb.productId.statusId.id, pb.productId.productName, pb.brandId.brandName, " +
            "pb.productId.subCategoryId.subCateName, pb.productId.sellPrice, " +
            "pb.productId.originPrice, pb.productId.quantity, pb.productId.color, " +
            "pb.productId.statusId.statusName) " +
            "from ProductBrand  pb " +
            "where pb.productId.productName like :productName and pb.productId.sellPrice >= :sellPrice and pb.brandId.id = :brandId and " +
            "pb.productId.subCategoryId.categoryId.id = :categoryId and pb.productId.statusId.id = :statusId")
    List<ProductResponse> search(@Param("productName") String name, @Param("sellPrice") Double price,
                                 @Param("brandId") Long brandId, @Param("categoryId") Long cateId, @Param("statusId") Long statusId);

}
