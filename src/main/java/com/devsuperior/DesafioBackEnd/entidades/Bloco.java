package com.devsuperior.DesafioBackEnd.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_bloco")
public class Bloco implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant inicio;
	private Instant fim;
	
	@ManyToOne
	@JoinColumn(name = "atividade_id")
	private Atividade atividade;

	public Bloco() {

	}

	public Bloco(Long id, Instant inicio, Instant fim, Atividade atividade) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.atividade = atividade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInicio() {
		return inicio;
	}

	public void setInicio(Instant inicio) {
		this.inicio = inicio;
	}

	public Instant getFim() {
		return fim;
	}



	public Atividade getAtividade() {
		return atividade;
	}

	@Override
	public String toString() {
		return "Bloco{" +
				"id=" + id +
				", inicio=" + inicio +
				", fim=" + fim +
				", atividade=" + atividade +
				'}';
	}
}
