package desafio1;

import java.sql.Statement;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaInsercao3 {

	public static void main(String[] args) throws SQLException {
		
		insercaoProdutos();	
	}

	private static void insercaoProdutos() throws SQLException {
		
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
				
		Statement stm = connection.createStatement();	
					
		//INGRESANDO 3 OFERTAS		
		String names [] = {"Notebool Dell","Notebook Positivo","Note Evolution"};
		String descricao[] = {"Notebook Dell Inspiron One","Notebook Positivo Max 1","Notebook Note Evolution"};
		String descontos [] = {"14500","17450","22650"};				
		String dataInicial [] = {"2021-10-12","2021-10-19","2021-10-05"};			
		String dataFim [] = {"2021-10-22","2021-10-30","2021-10-29"};							
		
				
		for(int i=0;i<names.length;i++) {
			BigDecimal desconto = new BigDecimal(descontos[i]);		
			LocalDate dataIni = LocalDate.parse(dataInicial[i]);	
			LocalDate dataFinal = LocalDate.parse(dataFim[i]);
			stm.execute("INSERT INTO PRODUTO (nome, descricao, desconto, dataInicio, dataFim) VALUES('"+names[i]+"', '"+descricao[i]+"','"+desconto+"','"+dataIni+"','"+dataFinal+"')"
					, Statement.RETURN_GENERATED_KEYS);	
			
					ResultSet rst = stm.getGeneratedKeys();
					
					while(rst.next()) {
						Integer id = rst.getInt(1);
						System.out.println("O id" + id + " foi criado com sucesso!!!");
					}			
		}
				
		connection.close();	
		
	}

}
