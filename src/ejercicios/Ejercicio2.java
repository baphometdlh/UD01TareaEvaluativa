package ejercicios;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/* Realiza un programa en Java que lea un fichero de texto y cree un nuevo fichero con las 
palabras palíndromas que encuentre. Es decir, si el fichero original contiene la frase “ana y 
lola son amigas”, el fichero resultante contendrá las palabras “ana” e “y”. Una palabra 
palíndroma es aquella que se lee igual de izquierda a derecha que de derecha a izquierda.  */

public class Ejercicio2 {

	public static void main(String[] args) {
		escribirFichero(leerFichero());
	}
	
	private static ArrayList<String> leerFichero() {
		
		ArrayList<String> listaPalabras = new ArrayList<>();
		
		try {
			File fichero = new File("." + File.separator + "src" + File.separator + 
					"ejercicios" + File.separator + "fichero2.txt");
			BufferedReader bfr = new BufferedReader(new FileReader (fichero));
			Scanner leerPalabra;
			
			
			String linea;
			String palabra;
			
			System.out.println("Las palabras palíndromas en el fichero son: ");
			
			while ((linea = bfr.readLine()) != null) {
				leerPalabra = new Scanner(linea);
				
				while(leerPalabra.hasNext()) {
					palabra = leerPalabra.next();
					if(esPalindromo(palabra) == true) {
						System.out.println(palabra);
						listaPalabras.add(palabra);
					}		
					
				}

			}
			bfr.close();
			
			
			
		}catch(Exception ex) {
			System.out.println("algo no va bien: " + ex.getMessage());
		}
		
		return listaPalabras;
		
	}
	
	public static void escribirFichero(ArrayList<String> listaPalabras) {
			
		
		try(BufferedWriter bfrWrite = new BufferedWriter(new FileWriter("." + File.separator + "src" + File.separator + 
				"ejercicios" + File.separator + "fichero2.txt"));) {
			
			for(int i=0; i<=listaPalabras.size()-1; i++) {
				bfrWrite.append(listaPalabras.get(i).toString() + "\n");
			}			
			
			bfrWrite.close();
			
		}catch(Exception ex) {
			System.out.println("algo no va bien: " + ex.getMessage());
		}
		
	}
	
	public static boolean esPalindromo(String palabra) {
		palabra = palabra.toLowerCase();
		
		StringBuilder reverso = new StringBuilder(palabra).reverse();
		
		return palabra.equals(reverso.toString());
		
	}

}
