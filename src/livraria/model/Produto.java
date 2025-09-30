package livraria.model;

public abstract class Produto {

	private int id;
	private String titulo;
	private float preco;
	private int estoque;
	private int categoria;
	
	// Metodo Construtor - Polimorfismo de Sobrecarga (Sobrecarga de Método) 
	public Produto(int id, String titulo, float preco, int estoque, int categoria) {
		this.id = id;
		this.titulo = titulo;
		this.preco = preco;
		this.estoque = estoque;
		this.categoria = categoria;
	}

	 // Metodos Get e Set que permitem acessar e modificar os dados dos atributos a partir de outras classes,
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public int getEstoque() {
		return estoque;
	}


	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	// Métodos Auxiliares
	public void visualizar() {

		String categoria = "\n ";

		switch (this.categoria) {
		case 1 -> categoria = "Livro Fisico";
		case 2 -> categoria = "eBook";
		default -> categoria = "Invalido";
		}
		
		System.out.println("\n••••••••••••••••••••••••••••••••••••");
		System.out.println("\nDados do Produto");
		System.out.printf("\nID do Produto: %d", this.id);
		System.out.printf("\nNome do Produto: %s", this.titulo);
		System.out.printf("\nValor do Produto: R$ %.2f", this.preco);
		System.out.printf("\nEstoque do Produto: %d", this.estoque);
		System.out.printf("\nTipo de Produto: %s", categoria);
		
	}


}
