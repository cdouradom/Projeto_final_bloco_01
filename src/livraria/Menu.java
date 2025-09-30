package livraria;

import java.util.InputMismatchException;
import java.util.Scanner;

import livraria.controller.ProdutoController;
import livraria.model.Ebook;
import livraria.model.Livro_Fisico;
import livraria.model.Produto;
import livraria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in); 

	private static final ProdutoController produtoController = new ProdutoController();

	public static void main(String[] args) {
		
		criarProdutosTeste(); // declarando a variavel de criar contas testes depois de ter criado o metodo para inserir pelo codigo e testar

		// Declaramos a variável do tipo int chamada opcao, que armazenará o ID do menu
		int opcao; 


		while (true) {
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_PURPLE_BOLD
					+ "••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
			System.out.println("                                                                ");
			System.out.println("                      Livraria Verso Dourado                    ");
			System.out.println("                                                                ");
			System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
			System.out.println("                                                                ");
			System.out.println("                         MENU DE OPÇOES                         ");
			System.out.println("                                                                ");
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("                 1 - Criar Novo Produto                         ");
			System.out.println("                 2 - Listar Todos os Produtos                   ");
			System.out.println("                 3 - Buscar Produto por ID                      ");
			System.out.println("                 4 - Buscar Produto por titulo                  ");
			System.out.println("                 5 - Atualizar Dados do Produto                 ");
			System.out.println("                 6 - Excluir Produto                            ");
			System.out.println("                 0 - SAIR                                       ");
			System.out.println("                                                                ");
			System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
			System.out.println("Por favor, entre com a opçao desejada:                          ");
			System.out.println("                                                                " + Cores.TEXT_RESET);

			// Início do bloco try, usado para capturar exceções que possam ocorrer durante a leitura da entrada do usuário
			try { 
				opcao = leia.nextInt();
				leia.nextLine();

			} catch (InputMismatchException e) { // captura a exceção InputMismatchException
				opcao = -1; // Caso a exceção seja lançada, define o valor da variável opcao como -1,
							// indicando que foi feita uma entrada inválida.
				System.out.println(Cores.TEXT_RED + "\nDigite um ID entre 0 e 6, conforme as opçoes do menu");
				leia.nextLine(); // Limpa o buffer e descarta um valor inválido para e evitar loop infinito ou
									// erros na próxima leitura
			}

			if (opcao == 0) {
				System.out.println(Cores.ANSI_WHITE_BACKGROUND_BRIGHT + Cores.TEXT_PURPLE_BOLD
						+ "\nLivraria Verso Dourado - O brilho da leitura na sua vida!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Criar novo produto!\n\n");

				cadastrarProduto();
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Listar todos os produtos!\n\n");

				listarProdutos();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Consultar dados do produto - por ID!\n\n");

				procurarProdutoPorId();
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Consultar dados do produto - por titulo do produto!\n\n");
				
				buscarPorTitulo();
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Atualizar dados do produto!\n\n");

				atualizarProduto() ;
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Deletar produto!\n\n");

				deletarProduto();
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opçao inválida! \nPor favor, escolha uma opçao válida.\n\n");

				keyPress();
				break;
			/*
			 * Utilizamos a estrutura switch (condicional por casos) para tratar as opções
			 * do menu, de 1 a 6. Cada ID acionará uma mensagem específica, simulando
			 * funcionalidades futuras. Se a entrada do usuário não corresponder a nenhuma
			 * dessas opções, será exibida a mensagem "Opção Inválida!".
			 * 
			 * Observe que, em todas as opções da estrutura switch-case do menu, foi
			 * adicionada a chamada ao método keyPress(). Essa inclusão garante que, após a
			 * execução de cada ação (como listar, cadastrar, atualizar, etc.), o sistema
			 * aguarde o usuário pressionar a tecla Enter antes de recarregar o menu.
			 */

			}

		}

	}

	// METODOS 
	
	// dados exibidos ao selecionada a opcao 0 finalizando o programa
	public static void sobre() {
		System.out.println("\n•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.println("Projeto Desenvolvido por: Cintia Marques Dourado                   ");
		System.out.println("Generation Brasil -- CintiaD@genstidents.org   	                   ");
		System.out.println("https://github.com/cdouradom/Projeto_final_bloco_01                ");
		System.out.println("\n•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
	}

	//Metodo KeyPress
	/*
	 * Declara o método keyPress() como public e static, ou seja, pode ser chamado
	 * diretamente sem a necessidade de instanciar a classe onde está definido. Ele
	 * não retorna nenhum valor (void) e não recebe parâmetros.
	 */
	public static void keyPress() {
		System.out.println(
				Cores.ANSI_WHITE_BACKGROUND_BRIGHT + Cores.TEXT_PURPLE_BOLD + "\n\nPressione Enter para continuar");
		leia.nextLine();
	}

	//Metodo responsavel por listar todos os produtos armazenados
	private static void listarProdutos() { // criado o metodo depois de configurar na controller
		produtoController.listarTodos();
	}

	//Metodo que vai criar produtos testes conforme os parametros dentro dele
	private static void criarProdutosTeste() { // criado o metodo depois de configurar na controller
		produtoController.cadastrar(
				new Livro_Fisico(produtoController.gerarId(), "Acensa Sua Luz", 33.99f, 730, 1, "Capa Dura"));
		produtoController
				.cadastrar(new Ebook(produtoController.gerarId(), "Sem Esforco", 21.49f, 225, 2, "PDF"));
	}

	//Metodo responsavel por procurar os produtos pelo ID informado
	private static void procurarProdutoPorId() { // criado o metodo depois de configurar na controller
		System.out.print("Digite o id da produto: ");
		int id = leia.nextInt();
		leia.nextLine();
		produtoController.procurarPorId(id);
	}

	//Metodo responsavel por criar novos produtos apos receber os dados digitados pelo usuario 
	private static void cadastrarProduto() { // criado o metodo depois de configurar na controller

		System.out.print("Digite o nome do produto: ");
		String titulo = leia.nextLine();

		System.out.print("Digite o preco: ");
		float preco = leia.nextFloat();

		System.out.print("Digite o estoque: ");
		int estoque = leia.nextInt();
		leia.skip("\\R");

		System.out.print("Digite o tipo do produto (1 - Livros Fisicos | 2 - eBook): ");
		int categoria = leia.nextInt();
		
		switch (categoria) {
		case 1 -> {
			System.out.print("Digite o tipo de capa do produto: ");
			leia.skip("\\R");
			String capa = leia.nextLine();
			produtoController
					.cadastrar(new Livro_Fisico(produtoController.gerarId(), titulo, preco, estoque, categoria, capa));
		}
		case 2 -> {
			System.out.print("Digite o formato do eBook ");
			leia.skip("\\R");
			String formato = leia.nextLine();
			produtoController
					.cadastrar(new Ebook(produtoController.gerarId(), titulo, preco, estoque, categoria, formato));
		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de produto inválido!" + Cores.TEXT_RESET);
		}
	}

	//Metodo responsavel por atualizar os dados do produtos apos receber novos dados digitados pelo usuario
	private static void atualizarProduto() { // criado o metodo depois de configurar na controller
		System.out.print("Digite o ID da Produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		Produto produto = produtoController.buscarNaCollection(id);

		if (produto != null) {
			String titulo = produto.getTitulo();
			float preco = produto.getPreco();
			int estoque = produto.getEstoque();
			int categoria = produto.getCategoria();

			System.out.printf("Titulo atual: %s\nNovo Titulo (pressione enter para manter): ", titulo);
			String entrada = leia.nextLine();
			titulo = entrada.isEmpty() ? titulo : entrada;

			System.out.printf("Preco atual: %.2f\nNovo preco (pressione enter para manter): ", preco);
			entrada = leia.nextLine();
			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(',', '.'));

			System.out.printf("Estoque atual: %d \nNovo estoque (pressione enter para manter): ", estoque);
			entrada = leia.nextLine();
			estoque = entrada.isEmpty() ? estoque : Integer.parseInt(entrada); // converter id para texto

			switch (categoria) {
			case 1 -> {
				String capa = ((Livro_Fisico) produto).getCapa();
				System.out.printf("Capa do produto eh: %s \n Nova capa(pressione enter para manter): ", capa);
				entrada = leia.nextLine();
				capa = entrada.isEmpty() ? capa : entrada;
				produtoController.atualizar(new Livro_Fisico(id, titulo, preco, estoque, categoria, capa));
			}
			case 2 -> {
				String formato = ((Ebook) produto).getFormato();
				System.out.printf("Formato atual: R$ %s \n Novo formtato(pressione enter para manter): ", formato);
				entrada = leia.nextLine();
				formato = entrada.isEmpty() ? formato : entrada;
				produtoController.atualizar(new Ebook(id, titulo, preco, estoque, categoria, formato));
			}
			default -> System.out.printf(Cores.TEXT_RED_BOLD + "Tipo de produto inválido!" + Cores.TEXT_RESET);
			}
		} else {
			System.out.printf("O produto '%d' nao foi encontrada!\n", id);
		}
	}

	//Metodo responsavel por deletar os produtos apos receber confirmacao do comando
	private static void deletarProduto() { // criado o metodo depois de configurar na controller
		System.out.print("Digite o ID da Produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		System.out.print("Tem certeza que deseja excluir esta produto? (SIM / NAO): ");
		String confirmacao = leia.nextLine();

		if (confirmacao.equalsIgnoreCase("Sim")) {
			produtoController.deletar(id);
		} else if (confirmacao.equalsIgnoreCase("Nao")) {
			System.out.println("\nOperação cancelada!");
		} else {
			System.out.println("\nOpção inválida! Operação cancelada.");
		}
	}
	
	//Metodo responsavel por procurar os produtos pelo TITULO informado
	private static void buscarPorTitulo() {
		System.out.print("Digite o nome do titulo do produto: ");
		String titulo = leia.nextLine();	
		
		produtoController.buscarPorTitulo(titulo);;

	}

}