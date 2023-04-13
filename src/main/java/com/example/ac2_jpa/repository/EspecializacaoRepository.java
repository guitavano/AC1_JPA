package com.example.ac2_jpa.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac2_jpa.model.Especializacao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class EspecializacaoRepository {
    @Autowired
    EntityManager entityManager;
    
    @Transactional
    public Especializacao inserir(Especializacao especializacao){
        return entityManager.merge(especializacao);
    }

    public List<Especializacao> obterTodos() {
        return entityManager
                .createQuery("from Especializacao", Especializacao.class)
                .getResultList();
    }
}
