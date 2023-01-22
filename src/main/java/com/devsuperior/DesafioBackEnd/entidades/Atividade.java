package com.devsuperior.DesafioBackEnd.entidades;


import com.devsuperior.DesafioBackEnd.dto.AtividadeDto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_atividade")
public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private Double preco;


	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "atividade")
	private List<Bloco> blocos = new ArrayList<>();

	@ManyToMany(mappedBy = "atividades")
	private Set<Participante> participantes = new HashSet<>();

	public Atividade() {
	}

	public Atividade(Long id, String nome, String descricao, Double preco, Categoria categoria, List<Bloco> blocos, Set<Participante> participantes) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
		this.blocos = blocos;
		this.participantes = participantes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Bloco> getBlocos() {
		return blocos;
	}



	public Set<Participante> getParticipantes() {
		return participantes;
	}

	@Override
	public String toString() {
		return "Nome do curso" + ": " + getNome();
	}
}
