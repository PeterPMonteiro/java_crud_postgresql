package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// metodo estatico

	public static Connection createConnection() throws Exception {

		// Informar o Driver de conex�o do postgresql
		Class.forName("org.postgresql.Driver");

		// abrir conex�o com o banco de dados                 porta:                      login:      senha:
		return DriverManager.getConnection("jdbc:postgresql://localhost:5434/bd_aula04", "postgres", "coti");
	}
}
