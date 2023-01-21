package com.devsuperior.DesafioBackEnd.controllers;
//1° teste da API

import com.devsuperior.DesafioBackEnd.entidades.Atividade;
import com.devsuperior.DesafioBackEnd.repositories.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController /*esta anotacao vai configurar para que quando a aplicacao rodar o que eu implementar nesta classe
vai estar respondendo pela web*/
@RequestMapping(value = "/atividade") /*Configura a rota */
public class AtividadeControllers {


    /*injetar componente de AtividadeRepository
    @Autowired e responsavel por injetar
     */
    @Autowired
    private AtividadeRepository repository;

    @GetMapping /*Configurar a operacao abaixo para que ela responda a rota pelo metodo HTTP
    determinada em @RequestMapping (value = "/Atividade")*/
    public String teste() {

        Optional<Atividade> result = repository.findById(1L);
        Atividade ativ = result.get();
        return ativ.toString();

    }


}