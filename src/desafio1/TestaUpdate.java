package desafio1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

