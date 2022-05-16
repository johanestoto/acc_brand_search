package com.acc.brand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acc.brand.model.Brand;
import org.springframework.data.domain.Sort;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findByDescBrandContainingIgnoreCaseOrderByCdBrandAsc(@Param("descBrand") String descBrand );
    
    List<Brand> findAllByOrderByCdBrandAsc();
}
