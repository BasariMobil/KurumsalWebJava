package com.basari.poc.rest.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateInfoRequest {

    private List<String> phoneList;

}
