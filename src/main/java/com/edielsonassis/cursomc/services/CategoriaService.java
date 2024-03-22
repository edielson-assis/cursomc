package com.edielsonassis.cursomc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edielsonassis.cursomc.domain.Categoria;
import com.edielsonassis.cursomc.repositories.CategoriaRepository;
import com.edielsonassis.cursomc.services.excepitions.ObjectNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public Categoria findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getSimpleName()));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }
}