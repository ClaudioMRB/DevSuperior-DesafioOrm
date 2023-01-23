package com.devsuperior.DesafioBackEnd.services.excecoes;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
