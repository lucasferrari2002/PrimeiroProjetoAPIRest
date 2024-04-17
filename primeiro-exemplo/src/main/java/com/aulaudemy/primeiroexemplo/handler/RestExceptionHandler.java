package com.aulaudemy.primeiroexemplo.handler;

import com.aulaudemy.primeiroexemplo.execption.ProdutoExecption;
import com.aulaudemy.primeiroexemplo.model.error.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ProdutoExecption.class)
    public ResponseEntity<?> handlerProdutoExecption(ProdutoExecption ex){
        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
