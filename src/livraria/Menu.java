package livraria;

import java.util.InputMismatchException;
import java.util.Scanner;

import livraria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in); // responsável por capturar as entradas digitadas pelo usuário no teclado
	public static void main(String[] args) {

	int opcao; // Declaramos a variável do tipo int chamada opcao, que armazenará o número do menu

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


			try { // Início do bloco try, usado para capturar exceções que possam ocorrer durante a leitura da entrada do usuário
				opcao = leia.nextInt();
				leia.nextLine(); 
									
			} catch (InputMismatchException e) { // captura a exceção InputMismatchException que ocorre ao digitar um
													// valor que não pode ser interpretado como inteiro, como letras ou
													// símbolos.
				opcao = -1; // Caso a exceção seja lançada, define o valor da variável opcao como -1,
							// indicando que foi feita uma entrada inválida.
				System.out.println(Cores.TEXT_RED + "\nDigite um número entre 0 e 6, conforme as opçoes do menu");
				
				leia.nextLine(); // Limpa o buffer e descarta um valor inválido para e evitar loop infinito ou erros na próxima leitura
			}

			if (opcao == 0) {
				System.out.println(Cores.ANSI_WHITE_BACKGROUND_BRIGHT + Cores.TEXT_PURPLE_BOLD + 
						"\nLivraria Verso Dourado - O brilho da leitura na sua vida! - O brilho da leitura na sua vida!");
				/*
				 * concatenamos a constante Cores.TEXT_PURPLE_BOLDD, para exibir a mensagem de
				 * finalização do programa em rosa com negrito.
				 */
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Criar Novo Produto!\n\n");

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Listar Todos os Produtos!\n\n");

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Consultar dados do Produto - por número!\n\n");

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Consultar dados do Produto - por titular da produto!\n\n");

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Atualizar dados bancários!\n\n");

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Deletar o Produto!\n\n");

				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opçao inválida! \nPor favor, escolha uma opçao válida.\n\n");

				keyPress();
				break;
			/*
			 * Utilizamos a estrutura switch (condicional por casos) para tratar as opções
			 * do menu, de 1 a 6. Cada número acionará uma mensagem específica, simulando
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

	// dados exibidos ao selecionada a opcao 0 finalizando o programa
	public static void sobre() {
		System.out.println("\n•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.println("Projeto Desenvolvido por: Cintia Marques Dourado                   ");
		System.out.println("Generation Brasil -- CintiaD@genstidents.org   	                   ");
		System.out.println("https://github.com/cdouradom/Projeto_final_bloco_01                ");
		System.out.println("\n•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
	}

	/*
	 * Declara o método keyPress() como public e static, ou seja, pode ser chamado
	 * diretamente sem a necessidade de instanciar a classe onde está definido. Ele
	 * não retorna nenhum valor (void) e não recebe parâmetros.
	 */
	public static void keyPress() {
		System.out.println(Cores.ANSI_WHITE_BACKGROUND_BRIGHT + Cores.TEXT_PURPLE_BOLD + "\n\nPressione Enter para continuar");
		leia.nextLine();
	}
}