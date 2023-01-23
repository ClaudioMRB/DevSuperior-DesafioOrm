package com.devsuperior.DesafioBackEnd.dto;

import com.devsuperior.DesafioBackEnd.entidades.Atividade;


public class AtividadeDto {


    private Long id;
    private String nome;
    private String descricao;
    private Double preco;




    public AtividadeDto() {
    }

  /*  public AtividadeDto(Long id, String nome, String descricao, Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;

    }*/

    public AtividadeDto(Atividade entity) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        preco = entity.getPreco();

    }

    public AtividadeDto(AtividadeDto x) {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
