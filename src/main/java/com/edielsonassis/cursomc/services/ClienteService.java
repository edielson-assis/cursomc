package com.edielsonassis.cursomc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edielsonassis.cursomc.domain.Cliente;
import com.edielsonassis.cursomc.repositories.ClienteRepository;
import com.edielsonassis.cursomc.services.excepitions.ObjectNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository repository;

    public Cliente findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getSimpleName()));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }
}