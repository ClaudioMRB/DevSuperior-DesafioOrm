package com.devsuperior.DesafioBackEnd.services.excecoes;

public class DatabaseException extends RuntimeException{


    public DatabaseException(String msg) {
        super(msg);
    }
}
