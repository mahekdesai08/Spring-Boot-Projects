package com.demo.service;
import com.demo.repository.housingRepository;
import com.demo.Model.housing;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class housingService {
    @Autowired
    housingRepository housingRepository;

    @Transactional
    public List<housing> saveALL(List<housing> housing1){
        System.out.println("data saved");
        return housingRepository.saveAll(housing1);
    }

    public double AverageSalePrice(){
        return housingRepository.AverageSalePrice();
    }

    public List<Object[]>  AverageSalePricePerLocation(){
        System.out.println(housingRepository.AverageSalePricePerLocation());
        return housingRepository.AverageSalePricePerLocation();
    }

    public int MaxSalePrice(){
        return housingRepository.maxSalePrice();
    }
    public int MinSalePrice(){
        return housingRepository.miSalePrice();
    }

    public  housing save(housing housing){
        return housingRepository.save(housing);
    }
}
