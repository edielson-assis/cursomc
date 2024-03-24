package com.edielsonassis.cursomc.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edielsonassis.cursomc.domain.Cliente;
import com.edielsonassis.cursomc.services.ClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    private final ClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        var cliente = service.findById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping        
    public ResponseEntity<List<Cliente>> finadAll() {
        var clientes = service.findAll();
        return ResponseEntity.ok().body(clientes);
    }
}