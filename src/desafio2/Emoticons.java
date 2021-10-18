package desafio2;

import java.util.Scanner;

public class Emoticons {
	
	static Scanner sc = new Scanner(System.in);
    private static String texto;
    private static String divertido = ":-)";
    private static String chateado = ":-(";     
    private static int tdivertido = 0;
    private static int tchateado = 0;

	public static void main(String[] args) {		
		comprovarFrase();		
	}
	
	public static void comprovarFrase() {
		
		do {
            System.out.println("\nEMOTICONS\n\nIntroduce texto: ");
            texto = sc.nextLine();
        } while (texto.isEmpty());	
		
		tchateado =  contarVeces(texto, chateado);
		tdivertido = contarVeces(texto, divertido);
		
		if(tchateado>tdivertido) {
        	System.out.println("\nSentimento expresso na mensagem é: CHATEADO");
        }
		else if(tdivertido>tchateado){
        	System.out.println("\nSentimento expresso na mensagem é: DIVERTIDO");
        }
		else System.out.println("\nSentimento expresso na mensagem é: NEUTRO");	
		
	}
	
	public static int contarVeces(String cadena, String secuencia) {	
        int posicion, contador = 0;
        //se busca la primera vez que aparece
        posicion = cadena.indexOf(secuencia);
        while (posicion != -1) { //mientras se encuentre
            contador++;           //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada
            posicion = cadena.indexOf(secuencia, posicion + 1);
        }
        return contador;
   }

}
