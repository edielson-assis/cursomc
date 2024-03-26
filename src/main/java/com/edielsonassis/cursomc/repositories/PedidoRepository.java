package com.edielsonassis.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edielsonassis.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {}