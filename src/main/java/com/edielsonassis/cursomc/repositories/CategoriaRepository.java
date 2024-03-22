package com.edielsonassis.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edielsonassis.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {}