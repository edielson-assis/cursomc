package com.edielsonassis.cursomc.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edielsonassis.cursomc.domain.Categoria;
import com.edielsonassis.cursomc.services.CategoriaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    private final CategoriaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        var categoria = service.findById(id);
        return ResponseEntity.ok().body(categoria);
    }

    @GetMapping        
    public ResponseEntity<List<Categoria>> finadAll() {
        var categorias = service.findAll();
        return ResponseEntity.ok().body(categorias);
    }
}