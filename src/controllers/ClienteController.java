package controllers;

import entities.Cliente;
import helpers.ClienteHelper;
import repositories.ClienteRepository;

public class ClienteController {

	// metodo para realizar o cadastro do cliente
	public void cadastrarCliente() {

		try {

			System.out.println("\nCadastro de Cliente\n");

			Cliente cliente = new Cliente();

			cliente.setNome(ClienteHelper.lerNome());
			cliente.setEmail(ClienteHelper.lerEmail());
			cliente.setTelefone(ClienteHelper.lerTelefone());
			
			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.create(cliente);
			
			System.out.println("\nCliente cadastrado com sucesso!!");

		} catch (Exception e) {
			System.out.println("\nErro:" + e.getMessage());
		}
	}
}
