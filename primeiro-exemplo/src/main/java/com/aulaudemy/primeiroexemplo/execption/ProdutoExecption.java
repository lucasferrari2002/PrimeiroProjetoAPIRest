package com.aulaudemy.primeiroexemplo.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProdutoExecption extends RuntimeException{
    public ProdutoExecption(String message) {
        super(message);
    }
}
