package com.edielsonassis.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edielsonassis.cursomc.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {}