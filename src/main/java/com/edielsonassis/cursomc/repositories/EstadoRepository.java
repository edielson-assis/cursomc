package com.edielsonassis.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edielsonassis.cursomc.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {}