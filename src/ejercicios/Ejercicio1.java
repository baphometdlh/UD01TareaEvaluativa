package ejercicios;

import java.io.*;
import java.util.ArrayList;


/*Realiza un programa en Java que lea un fichero y lo invierta. Es decir, si el fichero de 
entrada contiene “Hola mundo”, el fichero de salida contendrá “odnum aloH”. */

public class Ejercicio1 {
	
	//atributos
	static Object[] arrayLetras;
 
	public static void main(String[] args) {
		System.out.println("Primero leemos el fichero y contiene el siguiente texto: ");
		leerFichero();
		System.out.println("despues de invertir el contenido, tenemos el siguiente texto: ");
		escribirFichero();
	}
	
	private static void leerFichero() {
		
		try {
			File fichero = new File("." + File.separator + "src" + File.separator + 
					"ejercicios" + File.separator + "fichero.txt");
			FileReader fir = new FileReader(fichero);
			
			int i;
			char letra = 'a';
			ArrayList<Object> caracter = new ArrayList<>();
			
			while((i=fir.read())!=-1) {
				letra = (char)i;
				caracter.add(letra);				
			}
			
			arrayLetras = new String[caracter.size()];			
			arrayLetras = caracter.toArray();			
			
			for(int z=0; z<=arrayLetras.length - 1; z++ ) {
				System.out.print(arrayLetras[z].toString());
			}		
			
			System.out.println();
			System.out.println();
			
			fir.close();
			
		}catch(Exception ex) {
			System.out.println("algo no va bien: " + ex.getMessage());
		}

		
	}
	
	public static void escribirFichero() {
		try {
			File fichero = new File("." + File.separator + "src" + File.separator + 
					"ejercicios" + File.separator + "fichero.txt");
			FileWriter fir = new FileWriter(fichero);
			
			for(int z=arrayLetras.length - 1; z>=0; z-- ) {
				fir.write(arrayLetras[z].toString());
				System.out.print(arrayLetras[z].toString());
			}
			
			fir.close();
			
			
			
		}catch(Exception ex) {
			System.out.println("algo no va bien: " + ex.getMessage());
		}
		
	}
	
	
	

}
