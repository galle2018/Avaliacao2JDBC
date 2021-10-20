package desafio1.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestePopularBD {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		cargarDatos();
	}
	
	public static void cargarDatos() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		// Definimos el driver y la url		
		String sURL = "jdbc:mysql://localhost/avaliacao2?useTimezone=true&serverTimezone=UTC";
		Connection con = null;
				con = DriverManager.getConnection(sURL,"root","root");
		PreparedStatement stmt = con.prepareStatement("INSERT INTO produto VALUES (?,?,?,?,?)");
		
		String nome[]={"'Netbook Acer'",           "'Netbook Lenovo'",       "'Netbook Asus'"};
		String descricao[]= { "'Acer Aspire One'", "'Lenovo Evolution one'", "'Asus Ulimate Revolution'"};
		String desconto[]= {  "'11000'",           "'21000'",                "'22000'"};
		String dataInicio[]= {"'2021-10-15'",      "'2021-10-05'",           "'2021-10-01'"};
		String dataFim[]= {   "'2021-10-25'",      "'2021-10-30'",           "'2021-10-30'"};
		
		stmt.setString(1,nome[0]);
		stmt.setString(2,descricao[0]);
		stmt.setString(3,desconto[0]);
		stmt.setString(4,dataInicio[0]);
		stmt.setString(5,dataFim[0]);
		
		stmt.executeUpdate();
		
	}
}
