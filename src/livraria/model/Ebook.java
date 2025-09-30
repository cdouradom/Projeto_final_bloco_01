package livraria.model;

public class Ebook extends Produto{
	
	private String formato;
	
	public Ebook(int id, String titulo, float preco, int estoque, int categoria, String formato) {
		super(id, titulo, preco, estoque, categoria);
		this.formato = formato;

	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public void visualizar() {
		super.visualizar();
		System.out.printf("\nFormato do produto eh: %s\n", this.formato);
	}
	
}
