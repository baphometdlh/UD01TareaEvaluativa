package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* Realiza un programa en Java que lea un fichero de texto y cree un nuevo fichero con las 
palabras palíndromas que encuentre. Es decir, si el fichero original contiene la frase “ana y 
lola son amigas”, el fichero resultante contendrá las palabras “ana” e “y”. Una palabra 
palíndroma es aquella que se lee igual de izquierda a derecha que de derecha a izquierda.  */

public class Ejercicio2 {

	public static void main(String[] args) {
		leerFichero();
	}
	
	private static void leerFichero() {
		
		try {
			File fichero = new File("." + File.separator + "src" + File.separator + 
					"ejercicios" + File.separator + "fichero2.txt");
			BufferedReader bfr = new BufferedReader(new FileReader (fichero));
			
			String linea;
			
			while ((linea = bfr.readLine()) != null) {
				System.out.println(linea);
			}
			
		}catch(Exception ex) {
			System.out.println("algo no va bien: " + ex.getMessage());
		}
		
	}

}
