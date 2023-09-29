package ejercicios;

import java.io.*;
import java.io.InputStream;
import java.util.Arrays;

/*Realiza un programa en Java que lea la cabecera de un fichero ZIP y comprueba si 
realmente se trata de un fichero ZIP o no. Para que sea un ZIP válido la cabecera debe 
comenzar con la siguiente secuencia de bytes {80, 75, 3, 4}*/

public class Ejercicio3 {

	public static void main(String[] args) {
		esUnZIP();
	}
	
	private static void esUnZIP() {
		File fichero = new File("." + File.separator + "src" + File.separator + 
				"ejercicios" + File.separator + "fichero3.zip");
		
		byte[] secuencia = {80, 75, 3, 4}; 
		
		try(InputStream inputStream = new FileInputStream(fichero)){
			byte[] lectura = new byte[4];
			inputStream.read(lectura);
			
			if(!Arrays.equals(secuencia, lectura)) {
				System.out.println("el archivo NO es un ZIP");
			}else {
				System.out.println("el archivo SI es un ZIp");
			}
			
		}catch (Exception ex) {
			System.out.println("algo no va bien: " + ex.getMessage());
		}
		
	}

}