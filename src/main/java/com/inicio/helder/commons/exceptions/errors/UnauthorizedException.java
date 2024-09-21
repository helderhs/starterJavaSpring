package com.inicio.helder.commons.exceptions.errors;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String mensagem){
        super(mensagem);
    }
}
