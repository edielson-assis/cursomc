package com.edielsonassis.cursomc;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edielsonassis.cursomc.domain.Categoria;
import com.edielsonassis.cursomc.domain.Cidade;
import com.edielsonassis.cursomc.domain.Cliente;
import com.edielsonassis.cursomc.domain.Endereco;
import com.edielsonassis.cursomc.domain.Estado;
import com.edielsonassis.cursomc.domain.Produto;
import com.edielsonassis.cursomc.domain.enums.TipoCliente;
import com.edielsonassis.cursomc.repositories.CategoriaRepository;
import com.edielsonassis.cursomc.repositories.CidadeRepository;
import com.edielsonassis.cursomc.repositories.ClienteRepository;
import com.edielsonassis.cursomc.repositories.EnderecoRepository;
import com.edielsonassis.cursomc.repositories.EstadoRepository;
import com.edielsonassis.cursomc.repositories.ProdutoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	private final CategoriaRepository categoriaRepository;
	private final ProdutoRepository produtoRepository;
	private final EstadoRepository estadoRepository;
	private final CidadeRepository cidadeRepository;
	private final EnderecoRepository enderecoRepository;
	private final ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");

		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);

		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().add(produto2);

		produto1.getCategorias().add(categoria1);
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().add(categoria1);

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "Bahia");

		Cidade cidade1 = new Cidade(null, "Uberlândia", estado1);
		Cidade cidade2 = new Cidade(null, "Salvador", estado2);
		Cidade cidade3 = new Cidade(null, "Feira de Santana", estado2);

		estado1.getCidades().add(cidade1);
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));

		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));

		Cliente cliente1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);

		cliente1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cidade1, cliente1);
		Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cidade2, cliente1);

		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));

		clienteRepository.save(cliente1);
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
	}
}