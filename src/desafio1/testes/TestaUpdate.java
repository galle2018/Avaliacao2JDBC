package desafio1.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import desafio1.ConnectionFactory;

public class TestaUpdate {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
				
		Statement stm = connection.createStatement();	
		
		stm.execute("UPDATE `avaliacao2`.`produto` SET `desconto` = '13300' WHERE `id` = '1'");	
		
		System.out.println("O id atualizado foi: 1");
		
		connection.close();		
	}
}

