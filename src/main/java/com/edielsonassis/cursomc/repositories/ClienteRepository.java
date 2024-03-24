package com.edielsonassis.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edielsonassis.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {}