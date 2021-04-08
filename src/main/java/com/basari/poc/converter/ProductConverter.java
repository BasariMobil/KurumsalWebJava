package com.basari.poc.converter;

import com.basari.poc.entity.ProductEntity;
import com.basari.poc.rest.product.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements DtoConverter<ProductEntity, ProductDto> {
    
    @Override
    public ProductDto convertToDto(ProductEntity product) {
        return new ProductDto(product.getId(), product.getPhone(), product.getUserName()
                , product.getBillPlan(), product.getLineStatus(), product.getPaymentType(), product.getShortNumber());
    }
    
}
