package com.demo.repository;
import com.demo.Model.housing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface housingRepository extends JpaRepository <housing,Integer> {
    @Query(value = "SELECT AVG(sale_price) FROM housing", nativeQuery = true)
    Double AverageSalePrice();

   @Query(value = "SELECT location, AVG(sale_price)  FROM housing GROUP BY location", nativeQuery = true)
   List<Object[]> AverageSalePricePerLocation();

    @Query(value = "SELECT MAX(sale_price) FROM housing", nativeQuery = true)
    int maxSalePrice();

    @Query(value = "SELECT MIN(sale_price) FROM housing",nativeQuery = true)
    int miSalePrice();
}


