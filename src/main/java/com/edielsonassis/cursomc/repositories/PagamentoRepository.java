package com.edielsonassis.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edielsonassis.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {}