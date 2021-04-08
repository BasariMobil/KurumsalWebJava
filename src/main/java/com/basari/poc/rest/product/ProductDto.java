package com.basari.poc.rest.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    public String id;

    public String phone;

    private String userName;

    private String billPlan;

    private String lineStatus;

    private String paymentType;

    private Integer shortNumber;


}
