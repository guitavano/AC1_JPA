package com.example.ac2_jpa.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Professor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(length = 200, nullable = false)
    private String cpf;
    @Column(length = 200, nullable = false)
    private String rg;
    @Column(length = 200, nullable = false)
    private String celular;
    @Column(length = 200, nullable = false)
    private String cidade;
    @Column(length = 200, nullable = false)
    private String estado;
    @Column(length = 200, nullable = false)
    private String cep;
    @OneToMany(mappedBy = "professor")
    List<Agenda> agendas;
    @OneToMany(mappedBy = "professor")
    List<Especializacao> especializacoes;
    public Professor() {
    }
    public Professor(Long id, String nome, String cpf, String rg, String celular, String cidade, String estado,
            String cep) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.celular = celular;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public List<Agenda> getAgendas() {
        return agendas;
    }
    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }


}