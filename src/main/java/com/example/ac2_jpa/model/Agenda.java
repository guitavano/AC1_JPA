package com.example.ac2_jpa.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date dataInicio;
    @Column(nullable = false)
    private Date dataFim;
    @Column(length = 200, nullable = false)
    private String horaInicio;
    @Column(length = 200, nullable = false)
    private String horaFim;
    @Column(length = 200, nullable = false)
    private String cidade;
    @Column(length = 200, nullable = false)
    private String estado;
    @Column(length = 200, nullable = false)
    private String cep;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    public Agenda() {
    }
    public Agenda(Long id, Date dataInicio, Date dataFim, String horaInicio, String horaFim, String cidade,
            String estado, String cep, Professor professor, Curso curso) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.professor = professor;
        this.curso = curso;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    public String getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public String getHoraFim() {
        return horaFim;
    }
    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
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
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
