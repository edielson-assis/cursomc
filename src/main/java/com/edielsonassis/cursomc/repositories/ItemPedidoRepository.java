package com.edielsonassis.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edielsonassis.cursomc.domain.ItemPedido;
import com.edielsonassis.cursomc.domain.ItemPedidoPK;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {}