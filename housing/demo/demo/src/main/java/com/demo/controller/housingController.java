package com.demo.controller;
import com.demo.Model.housing;
import com.demo.service.housingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("house")
public class housingController {
    @Autowired
    housingService housingService;

//    @PostMapping("open")
//    public housing open(@RequestBody housing housing){
//      return  housingService.save(housing);
//    }

    @PostMapping("/openAll")
    public List<housing> openAll(@RequestBody List<housing> housing){
        return  housingService.saveALL(housing);
    }



    @GetMapping("/average-price")
    public ResponseEntity<Double> AverageSalePrice(){
        try {
            Double avg = housingService.AverageSalePrice();
            return ResponseEntity.ok(avg);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



   @GetMapping("/average-price-per-location")
   public ResponseEntity<List<Object[]>> getAverageSalePricePerLocation() {
        try {
            List<Object[]> averagePrices =housingService.AverageSalePricePerLocation();
            return ResponseEntity.ok(averagePrices);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

   }

    @GetMapping("/maxprice")
    public ResponseEntity<Integer> maxSalePrice(){
            int maxprice=housingService.MaxSalePrice();
            return ResponseEntity.ok(maxprice);
    }


    @GetMapping("/minprice")
    public ResponseEntity<Integer> minSalePrice(){
        int minprice=housingService.MinSalePrice();
        return ResponseEntity.ok(minprice);
    }
}
