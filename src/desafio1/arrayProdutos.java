package desafio1;

public class arrayProdutos {

	String produtos[];
			
	public static void main(String[] args) {
		
		arrayProdutos();
		
	}
		
	public static void arrayProdutos() {
		
		String produtos[] = {
				"'Netbook Acer','Acer Aspire One','11000','2021-10-15','2021-10-25'",
				"'Netbook Lenovo','Lenovo Evolution one','21000','2021-10-05','2021-10-30'",
				"'Netbook Asus','Asus Ulimate Revolution','22000','2021-10-01','2021-10-30'"};
		
		for (int i=0; i<3;i++){				
			System.out.println(produtos[i]);
			}
	}
	
	

}
