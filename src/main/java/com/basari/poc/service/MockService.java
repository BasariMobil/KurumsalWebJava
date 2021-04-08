package com.basari.poc.service;

import com.basari.poc.entity.MenuEntity;
import com.basari.poc.ex.RuntimeException;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
@Retryable(maxAttempts = 4,
        backoff = @Backoff(delay = 100),
        include = {
                TransientDataAccessException.class,
                RecoverableDataAccessException.class
        })
public class MockService  implements InitializingBean {

    @Autowired
    private MenuService menuService;

    @Autowired
    private ProductService productService;

    @Autowired
    private LogService logService;




    private final String[] menuNames = {"Fatura İşlemleri", "Tarife İşlemleri", "Paket İşlemleri", "Hat İşlemleri", "Ayarlar", "Ürün ve Servisler"
                            , "Faturasız Hat İşlemleri", "Yetkili ve Kullanıcı İşlemleri","Raporlama Merkezi", "İştecep Kampanyası"};




    @Override
    public void afterPropertiesSet() {
        menuService.deleteAll();
        productService.deleteAll();
        logService.deleteAll();

        for(String name: menuNames){
            menuService.createMenu(name);
        }
        createRandomProducts();
    }


    private void createRandomProducts(){

        int count = 0;
        String phone, userName;

        while (count < 1000){
            phone = randomPhone();
            userName = randomUserName();

            if(productService.create(phone, userName, "Hat Tipi", "Hat Durumu","Ödeme Tipi", 1111) != null){
                count++;
            }
        }
    }

        private String randomUserName(){
        return RandomStringUtils.random(6, true, false).toUpperCase() + " " + RandomStringUtils.random(7, true, false).toUpperCase();
    }

    private String randomPhone(){
        long leftLimit = 10000000, rightLimit = 99999999, generatedLong;
        generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        return  "053" + generatedLong;
    }


}
