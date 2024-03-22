package com.edielsonassis.cursomc;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edielsonassis.cursomc.domain.Categoria;
import com.edielsonassis.cursomc.repositories.CategoriaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	private final CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}
}