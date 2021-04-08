package com.basari.poc.ex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody
    ExceptionResponse notFound(HttpServletRequest request, Exception ex) {
        log.error("not found: {}", request.getRequestURL().toString(), ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        String[] exText = ex.getMessage().split(":");
        if(exText.length > 2){
            exceptionResponse.setTranslateMessage("No such user in this company");
        }else{
            exceptionResponse.setTranslateMessage(exText[0]);
        }
        exceptionResponse.setTranslateTitle(HttpStatus.NOT_FOUND);
        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AlreadyExistsException.class)
    public  @ResponseBody
    ExceptionResponse alreadyExists(HttpServletRequest request, Exception ex) {
        log.error("already exists: {}", request.getRequestURL().toString(), ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTranslateMessage("Already Exist!");
        exceptionResponse.setTranslateTitle(HttpStatus.CONFLICT);
        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody
    ExceptionResponse runtime(HttpServletRequest request, Exception ex) {
        log.error("expectation failed: {}", request.getRequestURL().toString(), ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTranslateMessage(ex.getMessage());
        exceptionResponse.setTranslateTitle(HttpStatus.EXPECTATION_FAILED);
        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public @ResponseBody
    ExceptionResponse illegalArgument(HttpServletRequest request, Exception ex) {
        log.error("illegal argument: {}", request.getRequestURL().toString(), ex);
        String[] exText = ex.getMessage().split(":");
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTranslateMessage(exText[0]);
        exceptionResponse.setData(exText.length == 1 ? null : exText[1].substring(1));
        exceptionResponse.setTranslateTitle(HttpStatus.BAD_REQUEST);
        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public @ResponseBody
    ExceptionResponse illegalState(HttpServletRequest request, Exception ex) {
        log.error("illegal state: {}", request.getRequestURL().toString(), ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTranslateMessage(ex.getMessage());
        exceptionResponse.setTranslateTitle(HttpStatus.BAD_REQUEST);
        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthorizationServiceException.class)
    public @ResponseBody
    ExceptionResponse unauthorized(HttpServletRequest request, Exception ex) {
        log.error("unauthorized: {}", request.getRequestURL().toString(), ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTranslateMessage("you do not have authority for this action");
        exceptionResponse.setTranslateTitle(HttpStatus.UNAUTHORIZED);
        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(GenException.class)
    public @ResponseBody
    ExceptionResponse generalException(HttpServletRequest request, Exception ex) {
        log.error("not acceptable: {}", request.getRequestURL().toString(), ex);

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTranslateMessage(ex.getMessage());
        exceptionResponse.setTranslateTitle(HttpStatus.NOT_ACCEPTABLE);

        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(IOException.class)
    public @ResponseBody
    ExceptionResponse ioException(HttpServletRequest request, Exception ex) {
        log.error("io exception: {}", request.getRequestURL().toString(), ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTranslateMessage(ex.getMessage());
        exceptionResponse.setTranslateTitle(HttpStatus.EXPECTATION_FAILED);
        return exceptionResponse;
    }
}
