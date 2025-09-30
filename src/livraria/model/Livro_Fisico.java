package livraria.model;

public class Livro_Fisico extends Produto{
	
	private String capa;

	public Livro_Fisico(int id, String titulo, float preco, int estoque, int categoria, String capa) {
		super(id, titulo, preco, estoque, categoria);
		this.capa = capa;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.printf("\nCapa do produto eh: %s\n", this.capa);
	}

}
