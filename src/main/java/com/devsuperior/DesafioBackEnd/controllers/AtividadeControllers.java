package com.devsuperior.DesafioBackEnd.controllers;
//1° teste da API

import com.devsuperior.DesafioBackEnd.dto.AtividadeDto;
import com.devsuperior.DesafioBackEnd.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /*esta anotacao vai configurar para que quando a aplicacao rodar o que eu implementar nesta classe
vai estar respondendo pela web*/
@RequestMapping(value = "/atividade") /*Configura a rota */
public class AtividadeControllers {


    /*injetar componente de AtividadeRepository
    @Autowired e responsavel por injetar
     */
    @Autowired
    private AtividadeService service;

    @GetMapping (value = "/{id}")/*Configurar a operacao abaixo para que ela responda a rota pelo metodo HTTP
    determinada em @RequestMapping (value = "/Atividade")*/
    public AtividadeDto findById(@PathVariable  Long id) {

        AtividadeDto dto = service.findById(id);
        return dto;

    }


}