package livraria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import livraria.model.Produto;
import livraria.repository.ProdutoRepository;
import livraria.util.Cores;

public class ProdutoController implements ProdutoRepository {

	private List<Produto> listaProdutos = new ArrayList<Produto>();

	int id = 0;

	@Override
	public void listarTodos() {
		for (var produto : listaProdutos) {
			produto.visualizar();

		}
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.printf(Cores.ANSI_WHITE_BACKGROUND_BRIGHT + Cores.TEXT_PURPLE_BOLD
				+ "O produto %d foi cadastrado com sucesso!\n", produto.getId());
	}

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getId());
		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.printf(Cores.ANSI_WHITE_BACKGROUND_BRIGHT + Cores.TEXT_PURPLE_BOLD
					+ "O produto '%d' foi atualizado com sucesso!\n", produto.getId());
		} else {
			System.out.printf(Cores.TEXT_PURPLE_UNDERLINED + Cores.ANSI_WHITE_BACKGROUND_BRIGHT
					+ "O produto '%d' nao foi encontrado!\n", id);
		}
	}

	@Override
	public void procurarPorId(int id) {
		var produto = buscarNaCollection(id);
		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.printf(Cores.TEXT_PURPLE_UNDERLINED + Cores.ANSI_WHITE_BACKGROUND_BRIGHT
					+ "O produto '%d' nao foi encontrado!\n", id);
		}
	}

	@Override
	public void deletar(int id) {
		var produto = buscarNaCollection(id);
		if (produto != null) {
			if (listaProdutos.remove(produto) == true) {
				System.out.printf(Cores.ANSI_WHITE_BACKGROUND_BRIGHT + Cores.TEXT_PURPLE_BOLD
						+ "O produto '%d' foi DELETADO com sucesso!\n", id);
			} else {
				System.out.printf(Cores.TEXT_PURPLE_UNDERLINED + Cores.ANSI_WHITE_BACKGROUND_BRIGHT
						+ "O produto '%d' nao foi encontrado!\n", id);
			}
		}
	}
	
	@Override
	public void buscarPorTitulo(String titulo) {
		List<Produto> listaTitulo = listaProdutos.stream()
				.filter(c -> c.getTitulo().toUpperCase().contains(titulo.toUpperCase())).collect(Collectors.toList());
		if (listaTitulo.isEmpty()) {
			System.out.printf("\nNenhuma produto foi encontrado com o titulo: %s", titulo);
		}
		for (var produto : listaTitulo) {
			produto.visualizar();
		}

	}

	// Metodos Auxiliares

	public int gerarId() { // eh o gerador de produto sequencial automatico
		return ++id;
	}

	public Produto buscarNaCollection(int id) {
		for (var produto : listaProdutos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}

}