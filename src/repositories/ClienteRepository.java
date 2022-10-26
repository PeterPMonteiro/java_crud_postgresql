package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import factories.ConnectionFactory;

public class ClienteRepository {

	// metodo para poder gravar um cliente em banco de dados
	private Connection connection;

	public void create(Cliente cliente) throws Exception {

		// abrir conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// escrevendo comandos de SQL para ser executado no banco de dados
		PreparedStatement statement = connection
				.prepareStatement("insert into cliente(nome, email, telefone) values(?, ?, ?)");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.execute();

		// fechando a conexão com o banco de dados
		connection.close();
	}

	// metodo para atualizar um cliente no banco de dados
	public void update(Cliente cliente) throws Exception {

		// abrir conexao com o banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// escrever um comando sql para executar o banco de dados
		PreparedStatement statement = connection
				.prepareStatement("update cliente set nome=?, email=? telefone=? where idcliente=?");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setInt(4, cliente.getIdCliente());

		// fechando conexao com banco de dados
		connection.close();

	}

	// metodo para excluir um cliente no banco de dados
	public void delete(Cliente cliente) throws Exception {

		// abrir conexao com banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// escrevendo um comando sql para executar no banco de dados
		PreparedStatement statement = connection.prepareStatement("delete from cliente where idcliente=?");
		statement.setInt(1, cliente.getIdCliente());
		statement.execute();

		// fechando conexão
		connection.close();
	}

	// metodo para consultar todos os clientes no banco de dados
	public List<Cliente> findAll() throws Exception {
		// abrir conexao com banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// escrever um comando SQL para executar no banco de dados
		PreparedStatement statement = connection.prepareStatement("select * from cliente");
		ResultSet resultSet = statement.executeQuery();

		// Criando uma lista de Clientes Vazia
		List<Cliente> lista = new ArrayList<Cliente>();

		// percorrer cada registro contido no ResultSet
		// enquanto houver registro, leia
		while (resultSet.next())
		{
			Cliente cliente = new Cliente();

			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setTelefone(resultSet.getString("telefone"));

			lista.add(cliente); // adicionando cada cliente dentro da lista
		}

		connection.close();// fechando conexao

		return lista;
	}

	// metodo para consultar 1 cliente no banco de dados pelo ID
	public Cliente findById(Integer idCliente) throws Exception {
		// abrir conexao com banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// escrevendo um comando sql para consultar no banco de dados
		PreparedStatement statement = connection.prepareStatement("select * from cliente where idcliente=?");
		statement.setInt(1, idCliente);
		ResultSet resultSet = statement.executeQuery();

		Cliente cliente = null;

		// se algum cliente foi encontrado
		if (resultSet.next()) {
			
			cliente = new Cliente();
			
			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setTelefone(resultSet.getString("telefone"));

		}
		connection.close(); // fechando conexao com o bando de dados
		return cliente;// retornando o cliente
	}
}
