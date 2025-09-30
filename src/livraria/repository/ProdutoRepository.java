package livraria.repository;

import livraria.model.Produto; //classe importada

public interface ProdutoRepository { // nesta etapa, apenas definimos as assinaturas dos métodos na interface ProdutoRepository, sem implementá-los aqui na repository.

	//Metodos relacionados ao CRUD - que serão implementados na classe ProdutoController
	
	public void listarTodos();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void procurarPorNumero(int id);
	public void deletar(int id);
	public void buscarPorTitulo(String titulo);
	
}
