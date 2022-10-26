package principal;

import java.util.Scanner;

import controllers.ClienteController;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		System.out.println("\n**** Controle de clientes ***\n");
		System.out.println("(1) - Cadastrar cliente");
		System.out.println("(2) - Atualizar cliente");
		System.out.println("(3) - Excluir cliente");
		System.out.println("(4) - Consultar todos os clientes");

		System.out.print("\nEscolha uma opção:");
		Integer opcao = Integer.parseInt(scanner.nextLine());

		ClienteController clienteController = new ClienteController();

		switch (opcao) {

		case 1: // cadastrar cliente
			clienteController.cadastrarCliente();
			break;

		case 2: // atualizar cliente
			clienteController.atualizarCliente();
			break;

		case 3: // excluir cliente
			clienteController.excluirCliente();
			break;

		case 4: // consultar todos os clientes
			clienteController.consultarClientes();
			break;

		default:
			System.out.println("\nOpçao invalida.");
			break;

		}
	}

}
