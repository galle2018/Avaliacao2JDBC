package desafio1.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import desafio1.ConnectionFactory;

public class ProdutoDAO {
					
	public static void cadastrar(String nome, String descricao, String desc, String dataInicio, String dataFim) throws SQLException {
				
			BigDecimal desconto = new BigDecimal(desc);		
			LocalDate dataIni = LocalDate.parse(dataInicio);	
			LocalDate dataFinal = LocalDate.parse(dataFim);
			
			ConnectionFactory criaConexao = new ConnectionFactory();
			Connection connection = criaConexao.recuperarConexao();
			Statement stm = connection.createStatement();	
			stm.execute("INSERT INTO PRODUTO (nome, descricao, desconto, dataInicio, dataFim) VALUES('"+nome+"', '"+descricao+"','"+desconto+"','"+dataIni+"','"+dataFinal+"')"
					, Statement.RETURN_GENERATED_KEYS);	
			
					ResultSet rst = stm.getGeneratedKeys();
					
					while(rst.next()) {
						Integer id = rst.getInt(1);						
						System.out.println("\nO id --> " + id + " foi criado e salvo com sucesso!!!");
					}
					
			connection.close();	
	}//fim cadastrar
	
	
	public static void atualizar(int id, String atributo, String valorR) throws SQLException {
		
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
				
		Statement stm = connection.createStatement();
		
		//os atributos desconto, dataInicio e dataFim sao recebidos em String e
		//seram convertidos seu valores aos tipos correspondentes antes de ser enviados a BD (BigDecimal e LocalDate)
		
		if(atributo=="desconto") {
			BigDecimal valor = new BigDecimal(valorR);	
			stm.execute("UPDATE `avaliacao2`.`produto` SET `"+atributo+"` = '"+valor+"' WHERE `id` = '"+id+"'");
		}
		else if(atributo=="dataInicio") {
			LocalDate dataIni = LocalDate.parse(valorR);			
			stm.execute("UPDATE `avaliacao2`.`produto` SET `"+atributo+"` = '"+dataIni+"' WHERE `id` = '"+id+"'");
		}
		else if(atributo=="dataFim") {			
			LocalDate dataFinal = LocalDate.parse(valorR);	
			stm.execute("UPDATE `avaliacao2`.`produto` SET `"+atributo+"` = '"+dataFinal+"' WHERE `id` = '"+id+"'");
		}
		else {
			stm.execute("UPDATE `avaliacao2`.`produto` SET `"+atributo+"` = '"+valorR+"' WHERE `id` = '"+id+"'");
		}				
		
		System.out.println("\nO Produto com id " +id+ " foi atualizado seu atributo "+atributo+" para "+valorR+" com sucesso!!!");
		
		connection.close();			
	}//fim atualizar
	
	
	public static void excluir(int id) throws SQLException {
		
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
				
		Statement stm = connection.createStatement();	
		
		stm.execute("DELETE FROM `avaliacao2`.`produto` WHERE (`id` = '"+id+"');");	
		
		System.out.println("O Produto om id "+id+" foi eliminado com sucesso!!!");
		
		connection.close();		
		
	}//fim excluir
	
	
	public static void rango(int inicio, int fim) throws SQLException {
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
				
		Statement stm = connection.createStatement();	
		
		//LISTADO CONTROLADO DE REGISTROS -----------------------------------------------------------------------------------------
				PreparedStatement stm1 = 
						connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE id>="+inicio+" and id<="+fim+"");
				stm1.execute();
				
				ResultSet rst = stm1.getResultSet();
				
				while(rst.next()) {
					System.out.println("------------------------------");
					Integer id = rst.getInt("ID");
					System.out.println("ID: "+id);
					String nome = rst.getString("NOME");
					System.out.println("NOME: "+nome);
					String descricao1 = rst.getString("DESCRICAO");
					System.out.println("DESCRICAO: "+descricao1);
					System.out.println("------------------------------");
				}
				//---------------------------------------------------------------------------------------------------------
				
				connection.close();
	}
	
	


}
