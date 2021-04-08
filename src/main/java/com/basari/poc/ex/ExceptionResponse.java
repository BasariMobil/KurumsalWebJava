package com.basari.poc.ex;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionResponse {

    private String translateMessage;

    private HttpStatus translateTitle;

    private String data;
}
