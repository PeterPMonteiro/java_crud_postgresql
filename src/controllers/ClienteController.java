package controllers;

import java.util.List;

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
	// metodo para realizar a edição de um cliente

	public void atualizarCliente() {

		try {
			System.out.println("\nAtualização de Cliente");

			Integer idCliente = ClienteHelper.lerIdCliente();

			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);

			if (cliente == null) {
				System.out.println("\nCliente não encontrado,verifique o ID do cliente.");
			} else {
				cliente.setNome(ClienteHelper.lerNome());
				cliente.setEmail(ClienteHelper.lerEmail());
				cliente.setTelefone(ClienteHelper.lerEmail());

				clienteRepository.update(cliente);

				System.out.println("\nCliente atualizado com sucesso.");

			}
		}

		catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}

	// metodo para realizar exlusao de cliente
	public void excluirCliente() {

		try {
			System.out.println("\nExclusão de Cliente\n");

			Integer idCliente = ClienteHelper.lerIdCliente();

			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);

			if (cliente == null) {
				System.out.println("\nCliente não encontrado, verifique o Id informado.");
			} 
			
			else {
				clienteRepository.delete(cliente);
				System.out.println("\nCliente excluido com sucesso!");
				
			}
		} catch (Exception e) {
			System.out.println("\nErro:" + e.getMessage());
		}
	}
	
		// metodo para consultar e imprimir todos os clientes cadastrados
	public void consultarClientes() {
		
		try {
			System.out.println("\nConsulta de Clientes\n");
			ClienteRepository clienteRepository = new ClienteRepository();
			List<Cliente> lista = clienteRepository.findAll();
			
			System.out.println("\nTotal de clientes:" + lista.size());
			
			//FOREACH (para cada..)
			for(Cliente cliente : lista) {
				
				System.out.println("\nCLIENTE: ");
				System.out.println("ID.......: " + cliente.getIdCliente());
				System.out.println("NOME.....: " + cliente.getNome());
				System.out.println("EMAIL....: " + cliente.getEmail());
				System.out.println("TELEFONE.: " + cliente.getTelefone());
			}
	 	}
		catch(Exception e) {
			System.out.println("\nErro:" + e.getMessage());
		}
	}
		
}

