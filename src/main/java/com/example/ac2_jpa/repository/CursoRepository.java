package com.example.ac2_jpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac2_jpa.model.Curso;
import com.example.ac2_jpa.model.Especializacao;
import com.example.ac2_jpa.model.Professor;
import com.example.ac2_jpa.model.Agenda;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {
    @Autowired
    EntityManager entityManager;
    EspecializacaoRepository especializacaoRepository;
    AgendaRepository agendaRepository;
    
    @Transactional
    public Curso inserir(Curso curso){
        return entityManager.merge(curso);
    }

    @Transactional
    public Curso editar(Curso curso) {
        return entityManager.merge(curso);
    }

    @Transactional
    public void excluir(Curso curso) {
        entityManager.remove(curso);
    }

    public Curso obterPorId(long id) {
        return entityManager.find(Curso.class, id);
    }

    public List<Curso> obterTodos() {
        return entityManager
                .createQuery("from Curso", Curso.class)
                .getResultList();
    }

    public List<Professor> obterProfessores(Curso curso){
        List<Professor> professores = new ArrayList<>();

        List<Especializacao> especializacoes = especializacaoRepository.obterTodos();

        for(Especializacao espec: especializacoes){
            if(espec.getCurso().getId().equals(curso.getId()) ){
                professores.add(espec.getProfessor());
            }
        }

        return professores;
    }

    public List<Agenda> obterAgendas(Curso curso){

        List<Agenda> agendas = new ArrayList<>();

        List<Agenda> allAgendas = agendaRepository.obterTodos();

        for(Agenda ag: allAgendas){
            if(ag.getCurso().getId().equals(curso.getId())){
                agendas.add(ag);
            }
        }

        return agendas;

    }
}
