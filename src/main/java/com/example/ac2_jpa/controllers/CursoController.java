package com.example.ac2_jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.ac2_jpa.model.Professor;
import com.example.ac2_jpa.model.Curso;
import com.example.ac2_jpa.model.Agenda;
import com.example.ac2_jpa.repository.CursoRepository;
import com.example.ac2_jpa.repository.ProfessorRepository;

@RestController
public class CursoController {

    @Autowired
    private ProfessorRepository professorRepository;
    private CursoRepository cursoRepository;

    @GetMapping(value = "/cursos")
    public List<Curso> listarCursos(){
        return cursoRepository.obterTodos();
    }

    @PostMapping(value = "/inserir")
    public Professor inserirProfessor(@RequestBody Professor professor){
        professorRepository.inserir(professor);
        return professor;
    }

    @GetMapping(value = "/professoresPorCurso")
    public List<Professor> listarProfessores(@RequestBody Curso curso){
        return cursoRepository.obterProfessores(curso);
    }

    @GetMapping(value = "/agendasPorCurso")
    public List<Agenda> listarAgendas(@RequestBody Curso curso){
        return cursoRepository.obterAgendas(curso);
    }

    
}
