package desafio1.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import desafio1.ConnectionFactory;

public class TestaDelete {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
				
		Statement stm = connection.createStatement();	
		
		stm.execute("DELETE FROM `avaliacao2`.`produto` WHERE (`id` = '2');");	
		
		System.out.println("O id eliminado foi o : 2");
		
		connection.close();		

	}

}
