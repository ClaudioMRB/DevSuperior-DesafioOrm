package com.devsuperior.DesafioBackEnd.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_participante")
public class Participante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(name = "tb_atividade_participante", joinColumns = @JoinColumn(name = "participante_id"), inverseJoinColumns = @JoinColumn(name = "atividades_id"))
    private Set<Atividade> atividades = new HashSet<>();

    public Participante() {
    }

    public Participante(Long id, String name, String email, Set<Atividade> atividades) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.atividades = atividades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    @Override
    public String toString() {
        return "Participante{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", atividades=" + atividades + '}';
    }
}
