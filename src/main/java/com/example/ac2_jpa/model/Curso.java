package com.example.ac2_jpa.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(length = 200, nullable = false)
    private String descricao;
    @Column(length = 200, nullable = false)
    private String cargaHoraria;
    @Column(length = 200, nullable = false)
    private String objetivo;
    @Column(length = 200, nullable = false)
    private String ementa;
    @OneToMany(mappedBy = "curso")
    List<Agenda> agendas;
    @OneToMany(mappedBy = "curso")
    List<Especializacao> especializacoes;
    public Curso() {
    }
    public Curso(Long id, String nome, String descricao, String cargaHoraria, String objetivo, String ementa) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.objetivo = objetivo;
        this.ementa = ementa;
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
    public String getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    public String getEmenta() {
        return ementa;
    }
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }
    public List<Agenda> getAgendas() {
        return agendas;
    }
    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

}
