package desafio1;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("INICIANDO CONEXAO!!!");
		
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
		
		System.out.println("FECHANDO CONEXAO!!!");
		
		connection.close();
	}

}
