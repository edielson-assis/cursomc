package com.edielsonassis.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edielsonassis.cursomc.domain.Categoria;
import com.edielsonassis.cursomc.domain.Cidade;
import com.edielsonassis.cursomc.domain.Cliente;
import com.edielsonassis.cursomc.domain.Endereco;
import com.edielsonassis.cursomc.domain.Estado;
import com.edielsonassis.cursomc.domain.ItemPedido;
import com.edielsonassis.cursomc.domain.Pagamento;
import com.edielsonassis.cursomc.domain.PagamentoComBoleto;
import com.edielsonassis.cursomc.domain.PagamentoComCartao;
import com.edielsonassis.cursomc.domain.Pedido;
import com.edielsonassis.cursomc.domain.Produto;
import com.edielsonassis.cursomc.domain.enums.EstadoPagamento;
import com.edielsonassis.cursomc.domain.enums.TipoCliente;
import com.edielsonassis.cursomc.repositories.CategoriaRepository;
import com.edielsonassis.cursomc.repositories.CidadeRepository;
import com.edielsonassis.cursomc.repositories.ClienteRepository;
import com.edielsonassis.cursomc.repositories.EnderecoRepository;
import com.edielsonassis.cursomc.repositories.EstadoRepository;
import com.edielsonassis.cursomc.repositories.ItemPedidoRepository;
import com.edielsonassis.cursomc.repositories.PagamentoRepository;
import com.edielsonassis.cursomc.repositories.PedidoRepository;
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
	private final PagamentoRepository pagamentoRepository;
	private final PedidoRepository pedidoRepository;
	private final ItemPedidoRepository itemPedidoRepository;

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

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Pedido pedido1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cliente1, endereco1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cliente1, endereco2);
		
		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		Pagamento pagamento1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pagamento1);
		
		Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("20/10/2017 00:00"), null);
		pedido2.setPagamento(pagamento2);
		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));

		ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 0.00, 1, 2000.00);
		ItemPedido itemPedido2 = new ItemPedido(pedido1, produto3, 0.00, 2, 80.00);
		ItemPedido itemPedido3 = new ItemPedido(pedido2, produto2, 100.00, 1, 800.00);

		pedido1.getItensPedido().addAll(Arrays.asList(itemPedido1, itemPedido2));
		pedido2.getItensPedido().add(itemPedido3);

		produto1.getItensPedido().add(itemPedido1);
		produto2.getItensPedido().add(itemPedido3);
		produto3.getItensPedido().add(itemPedido2);

		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
	}
}