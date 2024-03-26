package com.edielsonassis.cursomc.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edielsonassis.cursomc.domain.Pedido;
import com.edielsonassis.cursomc.services.PedidoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    private final PedidoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
        var pedido = service.findById(id);
        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping        
    public ResponseEntity<List<Pedido>> finadAll() {
        var pedidos = service.findAll();
        return ResponseEntity.ok().body(pedidos);
    }
}