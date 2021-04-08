package com.basari.poc.test;

import com.basari.poc.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductControllerTest {



    @Autowired
    private ProductService productService;



    @Test
    public void getProduct() {

        productService.create("TestPhone", "TestName", "TestBill", "TestStatus", "TestPayment", 111111);
        Assert.assertEquals("TestName", productService.getProductByPhone("TestPhone").getUserName());

        Integer shortNumber = productService.getProductByPhone("TestPhone").getShortNumber();
        productService.updateProductWithRandomNumber("TestPhone");
        Assert.assertNotEquals(shortNumber, productService.getProductByPhone("TestPhone").getUserName());
        productService.delete(productService.getProductByPhone("TestPhone"));

    }

}


