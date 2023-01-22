package com.devsuperior.DesafioBackEnd.controllers;
//1° teste da API

import com.devsuperior.DesafioBackEnd.dto.AtividadeDto;
import com.devsuperior.DesafioBackEnd.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    determinada em @RequestMapping (value = "/Atividade")
    buscar dados por ID*/
    public ResponseEntity<AtividadeDto> findById(@PathVariable  Long id) {

        AtividadeDto findbyid = service.findById(id);
        return ResponseEntity.ok(findbyid);

    }

    @GetMapping /*Configurar a operacao abaixo para que ela responda a rota pelo metodo HTTP
    determinada em @RequestMapping (value = "/Atividade")
    buscar dados gerais*/
    public ResponseEntity<Page<AtividadeDto>> findAll(Pageable pageable) {
        Page<AtividadeDto> findAllDto = service.findAll(pageable);
        return ResponseEntity.ok(findAllDto);

    }


    @PostMapping //inserir dados no banco
    public ResponseEntity<AtividadeDto> insert(@RequestBody AtividadeDto insertDto) {

        insertDto = service.Insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertDto.getId()).toUri();
        return ResponseEntity.created(uri).body(insertDto);
    }

    @PutMapping(value = "/{id}") //Atualizar dados no banco
    public ResponseEntity<AtividadeDto> update(@PathVariable Long id, @RequestBody AtividadeDto updateDto) {

        updateDto = service.update(id, updateDto);
        return ResponseEntity.ok(updateDto);


    }
}