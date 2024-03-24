package com.edielsonassis.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edielsonassis.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {}