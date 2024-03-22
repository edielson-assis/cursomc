package com.edielsonassis.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edielsonassis.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {}