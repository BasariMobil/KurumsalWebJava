package com.basari.poc.controller;

import com.basari.poc.converter.ProductConverter;
import com.basari.poc.rest.product.ProductDto;
import com.basari.poc.rest.product.UpdateInfoRequest;
import com.basari.poc.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductConverter productConverter;




    @GetMapping("/all-list")
    public List<ProductDto> getProductList(){
        return productService.getProductList().stream().map(productConverter:: convertToDto).collect(Collectors.toList());
    }

    @PostMapping("/update-info")
    public void updateProductInfo(@RequestBody UpdateInfoRequest request){
        try {
            request.getPhoneList().forEach(productService::updateProductWithRandomNumber);
        }catch (Exception e){
            log.warn("Products could not updated!");
        }
    }

}
