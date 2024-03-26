package com.edielsonassis.cursomc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edielsonassis.cursomc.domain.Pedido;
import com.edielsonassis.cursomc.repositories.PedidoRepository;
import com.edielsonassis.cursomc.services.excepitions.ObjectNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PedidoService {

    private final PedidoRepository repository;

    public Pedido findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getSimpleName()));
    }

    public List<Pedido> findAll() {
        return repository.findAll();
    }
}