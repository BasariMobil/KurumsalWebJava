package com.basari.poc.service;

import com.basari.poc.entity.ProductEntity;
import com.basari.poc.ex.RuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductEntity.Repository repository;

    @Autowired
    private LogService logService;




    public ProductEntity create(String phone, String userName, String billPlan, String lineStatus, String paymentType, Integer shortNumber){
        ProductEntity product = new ProductEntity();
        product.setPhone(phone);
        product.setUserName(userName);
        product.setBillPlan(billPlan);
        product.setLineStatus(lineStatus);
        product.setPaymentType(paymentType);
        product.setShortNumber(shortNumber);
        product = repository.save(product);
        logService.createLog("Product Create", product.toString());
        return product;
    }



    public ProductEntity getProductByPhone(String phone){
        return repository.findFirstByPhone(phone).orElse(null);
    }

    @Async("asyncTask")
    public void updateProductWithRandomNumber(String phone){
        ProductEntity productEntity = getProductByPhone(phone);
        if(productEntity != null){
            productEntity.setShortNumber(randomShortNumber());
            repository.save(productEntity);
            logService.createLog("Product Update With Random Number", phone);
        }

    }

    public List<ProductEntity> getProductList(){
        return repository.findAll();
    }

    public Integer randomShortNumber(){
        int leftLimit = 1000, rightLimit = 9999 ;
        return leftLimit + (int)(Math.random() * (rightLimit - leftLimit));
    }

    public void deleteAll(){
        repository.deleteAll();
        logService.createLog("Product Delete All", null);
    }

    public void delete(ProductEntity productEntity){
        repository.delete(productEntity);
    }


}
