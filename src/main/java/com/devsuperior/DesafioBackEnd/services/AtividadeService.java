package com.devsuperior.DesafioBackEnd.services;

import com.devsuperior.DesafioBackEnd.dto.AtividadeDto;
import com.devsuperior.DesafioBackEnd.entidades.Atividade;
import com.devsuperior.DesafioBackEnd.repositories.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository repository;

    @Transactional(readOnly = true)
    public AtividadeDto findById(Long id) {

        Optional<Atividade> result = repository.findById(id);
        Atividade ativ = result.get();
        //AtividadeDto dto = new AtividadeDto(ativ.getId(), ativ.getNome(), ativ.getDescricao(), ativ.getPreco());
        AtividadeDto dto = new AtividadeDto(ativ);
        return dto;

    }

}
