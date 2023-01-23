package com.devsuperior.DesafioBackEnd.services;

import com.devsuperior.DesafioBackEnd.dto.AtividadeDto;
import com.devsuperior.DesafioBackEnd.entidades.Atividade;
import com.devsuperior.DesafioBackEnd.repositories.AtividadeRepository;
import com.devsuperior.DesafioBackEnd.services.excecoes.ResourceNotFoundExcepition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository repository;

    @Transactional(readOnly = true)
    //Buscar por id
    public AtividadeDto findById(Long id) {

           Optional<Atividade> result = repository.findById(id);
           Atividade ativ = result.orElseThrow(() -> new ResourceNotFoundExcepition("Recurso não encontrado"));
           //AtividadeDto dto = new AtividadeDto(ativ.getId(), ativ.getNome(), ativ.getDescricao(), ativ.getPreco());
           AtividadeDto dto = new AtividadeDto(ativ);
           return dto;



    }

    @Transactional(readOnly = true)
    //Buscar por todos os itens
    public Page<AtividadeDto> findAll(Pageable pageable) {
        //public Page<AtividadeDto> findAll(Pageable pageable)
        //List<Atividade> result = repository.findAll();
        Page<Atividade> result = repository.findAll(pageable);
        //List<Atividade> result = repository.findAll()
        //return result.stream().map(x -> new AtividadeDto(x)).toList();
        //converter um page de atividadeDto
        return result.map(x -> new AtividadeDto(x));
    }

    @Transactional(readOnly = true)
    //Inserir dados no banco
    public AtividadeDto Insert(AtividadeDto dto) {

        Atividade entity = new Atividade();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new AtividadeDto(entity);

    }

    @Transactional(readOnly = true)
    //Atualizar dados no banco
    public AtividadeDto update(Long id, AtividadeDto dto) {

        Atividade entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new AtividadeDto(entity);

    }

    @Transactional
    //Deletar dados no banco por id
    public void delete(Long id) {
        repository.deleteById(id);

    }

    private void copyDtoToEntity(AtividadeDto dto, Atividade entity) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());


    }


}
