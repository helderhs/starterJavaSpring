package com.inicio.helder.exceptions.errors;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String mensagem){
        super(mensagem);
    }
}
