package desafio1.testes;

import java.sql.Statement;
import java.time.LocalDate;

import desafio1.ConnectionFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaInsercao20 {

	public static void main(String[] args) throws SQLException {		
		ingresar();
		listar();			
	}

	private static void ingresar() throws SQLException {
		
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
				
		Statement stm = connection.createStatement();			
			
		//ingresando varios registros desde arrays
		
		String names [] = {	"Notebool Dell","Notebook Positivo","Note Evolution", 
							"Notebool Dell","Notebook Positivo","Note Evolution", 
							"Notebool Dell","Notebook Positivo","Note Evolution", 
							"Notebool Dell","Notebook Positivo","Note Evolution", 
							"Notebool Dell","Notebook Positivo","Note Evolution", 
							"Notebool Dell","Notebook Positivo","Note Evolution",
							"Notebool Dell","Notebook Positivo","Note Evolution"};
		
		String descricao[] = {	"Notebook Dell Inspiron One","Notebook Positivo Max 1","Notebook Note Evolution I",
								"Notebook Dell Inspiron Two","Notebook Positivo Max 2","Notebook Note Evolution II",
								"Notebook Dell Inspiron Trhree","Notebook Positivo Max 3","Notebook Note Evolution III",
								"Notebook Dell Inspiron Four","Notebook Positivo Max 4","Notebook Note Evolution IV",
								"Notebook Dell Inspiron Fine","Notebook Positivo Max 5","Notebook Note Evolution",
								"Notebook Dell Inspiron Six","Notebook Positivo Max 6","Notebook Note Evolution V",
								"Notebook Dell Inspiron Seven","Notebook Positivo Max 7","Notebook Note Evolution VI"};
		
		String descontos [] = {	"14500","17450","22650",
								"14500","17450","22650",
							 	"14500","17450","22650",
							 	"14500","17450","22650",
			                    "14500","17450","22650",
			                    "14500","17450","22650",
			                    "14500","17450","22650"};	
		
		String dataInicial [] = {"2021-10-12","2021-10-19","2021-10-05",
								 "2021-10-12","2021-10-19","2021-10-05",
								 "2021-10-19","2021-10-05","2021-10-19",
								 "2021-10-05","2021-10-19","2021-10-05",
								 "2021-10-05","2021-10-19","2021-10-05",
								 "2021-10-05","2021-10-19","2021-10-05",
								 "2021-10-05","2021-10-19","2021-10-05"};
		
		String dataFim [] = {	"2021-10-22","2021-10-30","2021-10-29",
								"2021-10-22","2021-10-30","2021-10-29",
								"2021-10-22","2021-10-30","2021-10-29",
								"2021-10-22","2021-10-30","2021-10-29",
								"2021-10-22","2021-10-30","2021-10-29",
								"2021-10-22","2021-10-30","2021-10-29",
								"2021-10-22","2021-10-30","2021-10-29"};		
		
		for(int i=0;i<names.length;i++) {
			BigDecimal desconto = new BigDecimal(descontos[i]);		
			LocalDate dataIni = LocalDate.parse(dataInicial[i]);	
			LocalDate dataFinal = LocalDate.parse(dataFim[i]);
			stm.execute("INSERT INTO PRODUTO (nome, descricao, desconto, dataInicio, dataFim) VALUES('"+names[i]+"', '"+descricao[i]+"','"+desconto+"','"+dataIni+"','"+dataFinal+"')"
					, Statement.RETURN_GENERATED_KEYS);			
					ResultSet rst = stm.getGeneratedKeys();
					while(rst.next()) {
						Integer id = rst.getInt(1);
						System.out.println("O id criado foi: " + id);
					}			
		}
		
		//LISTADO CONTROLADO DE REGISTROS DEL 4-40 ---------------------------------------------------------------
		PreparedStatement stm1 = 
				connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE id>3 and id<11");
		stm1.execute();
		
		ResultSet rst = stm1.getResultSet();
		
		while(rst.next()) {
			System.out.println("------------------------------");
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String nome = rst.getString("NOME");
			System.out.println(nome);
			String descricao1 = rst.getString("DESCRICAO");
			System.out.println(descricao1);
			System.out.println("------------------------------");
		}
		//---------------------------------------------------------------------------------------------------------
		
		connection.close();
		
	}
	
	private static void listar() {
		
		
	}

}
