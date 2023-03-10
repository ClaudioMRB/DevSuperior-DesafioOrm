package com.devsuperior.DesafioBackEnd.services;

import com.devsuperior.DesafioBackEnd.dto.AtividadeDto;
import com.devsuperior.DesafioBackEnd.entidades.Atividade;
import com.devsuperior.DesafioBackEnd.repositories.AtividadeRepository;
import com.devsuperior.DesafioBackEnd.services.excecoes.DatabaseException;
import com.devsuperior.DesafioBackEnd.services.excecoes.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository repository;

    @Transactional(readOnly = true)
    //Buscar por id
    public AtividadeDto findById(Long id) {

           Optional<Atividade> result = repository.findById(id);
           Atividade ativ = result.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
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

       try{
           Atividade entity = repository.getReferenceById(id);
           copyDtoToEntity(dto, entity);
           entity = repository.save(entity);
           return new AtividadeDto(entity);
       }catch(EntityNotFoundException e){
           throw new ResourceNotFoundException("Recurso não encontrado");
       }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    //Deletar dados no banco por id
    public void delete(Long id) {
        try{
            repository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new  ResourceNotFoundException("Recurso não encontrado");
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
        }


    }

    private void copyDtoToEntity(AtividadeDto dto, Atividade entity) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());


    }


}
