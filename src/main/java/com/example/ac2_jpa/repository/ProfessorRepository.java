package com.example.ac2_jpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac2_jpa.model.Professor;
import com.example.ac2_jpa.model.Curso;
import com.example.ac2_jpa.model.Especializacao;
import com.example.ac2_jpa.model.Agenda;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ProfessorRepository {
    @Autowired
    EntityManager entityManager;
    EspecializacaoRepository especializacaoRepository;
    AgendaRepository agendaRepository;
    
    @Transactional
    public Professor inserir(Professor professor){
        return entityManager.merge(professor);
    }

    @Transactional
    public Professor editar(Professor professor) {
        return entityManager.merge(professor);
    }

    @Transactional
    public void excluir(Professor professor) {
        entityManager.remove(professor);
    }

    public Professor obterPorId(long id) {
        return entityManager.find(Professor.class, id);
    }

    public List<Professor> obterTodos() {
        return entityManager
                .createQuery("from Professor", Professor.class)
                .getResultList();
    }

    public List<Curso> obterCursos(Professor professor){
        List<Curso> cursos = new ArrayList<>();

        List<Especializacao> especializacoes = especializacaoRepository.obterTodos();

        for(Especializacao espec: especializacoes){
            if(espec.getProfessor().getId().equals(professor.getId()) ){
                cursos.add(espec.getCurso());
            }
        }

        return cursos;
    }

    public List<Agenda> obterAgendas(Professor professor){

        List<Agenda> agendas = new ArrayList<>();

        List<Agenda> allAgendas = agendaRepository.obterTodos();

        for(Agenda ag: allAgendas){
            if(ag.getProfessor().getId().equals(professor.getId())){
                agendas.add(ag);
            }
        }

        return agendas;

    }
}
