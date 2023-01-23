package com.devsuperior.DesafioBackEnd.services.excecoes;

public class ResourceNotFoundExcepition extends RuntimeException{


    public ResourceNotFoundExcepition(String msg) {
        super(msg);
    }
}
