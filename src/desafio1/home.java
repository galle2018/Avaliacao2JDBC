package desafio1;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import desafio1.dao.ProdutoDAO;
import desafio1.modelo.Produto;
import desafio2.Emoticons;

public class home {

	static Scanner sc = new Scanner(System.in);	
	
	public static void main(String[] args) throws ParseException, SQLException {
		
		String escolha;
		do {
            System.out.println("\n> HOME"
            		         + "\n-------------------------------------------"
            		         + "\n1 - Cadastrar Ofertas"
            		         + "\n2 - Atualizar 1era. Oferta"
            		         + "\n3 - Excluir 2da. Oferta"
            		         + "\n4 - Popular BD com 21 produtos extras (automatico)"
            		         + "\n5 - Ver range de registros "
            		         + "\n6 - Emoticons "
            		         + "\n0 - Sair"            		       
            		         + "\n-------------------------------------------"
            		         + "\nEscolha: ");
            
            escolha = sc.nextLine();
            
            switch(escolha) {
            	
            	case "0":
            		System.out.println("\nAte a proxima!!!\nObrigado por usar este sistema.");
            		System.exit(0);
            		break;
            		
            	case "1":
            		System.out.println("Cadastrando 3 Ofertas");
            		cadastrarOfertas();
            		break;
            		
            	case "2":
            		System.out.println("Actualizando Oferta 1");
            		atualizarPrimerRegistro();
            		break;
            		
            	case "3":
            		System.out.println("Excluindo Oferta 2");
            		excluirSegundaOferta();
            		break;
            		
            	case "4":
            		System.out.println("Populando com 20 Ofertas a BD");
            		popularBD();
            		break;
            		
            	case "5":
            		System.out.println("Visualizando range de registros da BD\n");            		
            		verRango();
            		break; 
            		
            	case "6":
            		Emoticons.comprovarFrase();
            		break;
            		
            	default :
            		break;
            }
            
        } while (escolha!="0");				

	}	
	

	private static void cadastrarOfertas() throws ParseException, SQLException {
		String names [] = {"Notebook Dell","Notebook Positivo","Note Evolution"};
		String descricao[] = {"Notebook Dell Inspiron One","Notebook Positivo Max 1","Notebook Note Evolution"};
		String descontos [] = {"14500","17450","22650"};
		String dataInicial [] = {"2021-10-12","2021-10-19","2021-10-05"};
		String dataFim [] = {"2021-10-22","2021-10-30","2021-10-29"};
		
		
		for (int i=0;i<names.length;i++) {
			Produto produtos=new Produto(names[i], descricao[i], descontos[0], dataInicial[i], dataFim[i]);
			ProdutoDAO.cadastrar(produtos.getNome(),produtos.getDescricao(),produtos.getDesconto(),produtos.getDataInicio(),produtos.getDataFim());
			System.out.println(produtos);
		}			
		
	}
	
	
	private static void atualizarPrimerRegistro() throws SQLException {
		int id=1;
		String atributo="desconto";
		String valor="10450";
		ProdutoDAO.atualizar(id, atributo, valor);
	}
	
	private static void excluirSegundaOferta() throws SQLException {		
		ProdutoDAO.excluir(2);
	}
	
	private static void popularBD() throws SQLException {	
		
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
		
		for (int i=0;i<names.length;i++) {
			Produto produtos=new Produto(names[i], descricao[i], descontos[0], dataInicial[i], dataFim[i]);
			ProdutoDAO.cadastrar(produtos.getNome(),produtos.getDescricao(),produtos.getDesconto(),produtos.getDataInicio(),produtos.getDataFim());
			System.out.println(produtos);
		}		
		
	}//fim popularBD

	private static void verRango() throws SQLException {
		sc = new Scanner(System.in);	
		System.out.println("A partir do registro: ");
		int inicio = sc.nextInt();
		System.out.println("Ate o registro: ");
		int fim = sc.nextInt();		
		ProdutoDAO.rango(inicio,fim);
	}
	
}
