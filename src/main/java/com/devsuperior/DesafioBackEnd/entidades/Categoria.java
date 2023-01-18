package com.devsuperior.DesafioBackEnd.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;

	@OneToMany(mappedBy = "categoria")
	private List<Atividade> atividades = new ArrayList<>();

	public Categoria() {
	}

	public Categoria(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	@Override
	public String toString() {
		return "Categoria{" +
				"id=" + id +
				", descricao='" + descricao + '\'' +
				", atividades=" + atividades +
				'}';
	}
}
