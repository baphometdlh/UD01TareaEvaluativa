package ejercicios;

import java.io.*;
import java.util.ArrayList;

/*c). Realiza un programa en Java que te permita visualizar los personajes de un tipo 
concreto (héroe o villano). El programa recibe desde la línea de comandos el tipo de 
personaje y visualiza cuantos personajes hay de dicho tipo y todos los datos de dichos 
personajes. Verifica que exista dicho tipo en el fichero, si no existe saca un mensaje de 
error por pantalla.*/

public class Ejercicio4c {

	public static void main(String[] args) throws IOException {
		try {
			File fichero = new File("." + File.separator + "src" + File.separator + 
					"ejercicios" + File.separator + "Marvel.dat");
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			String tipoConsola, tipoFichero = null, dniSalida, nombreSalida, identidadSalida, tipoSalida;
			int peso, altura, posicion, cont=0;
			char tipo[] = new char[10], aux;
			char dni[] = new char[9]; 
			char nombre[] = new char[10];
			char identidad[] = new char[20];
			Personaje unPersonaje;
			ArrayList<Personaje> unArrayPersonajes = new ArrayList<>();
			
			System.out.println("Introduce un tipo de personaje: ");
			tipoConsola = Consola.readString();
			posicion = 82;
			
			while(posicion <= file.length()) {
								
				file.seek(posicion);
				
				for(int i=0; i<tipo.length; i++) {						
					aux = file.readChar();					
					tipo[i] = aux;					
				}
				
				tipoFichero = new String(tipo).trim();
				
				if(tipoFichero.equals(tipoConsola)) {
					cont++;
					
					posicion = posicion - 78;
					file.seek(posicion);
					for(int i=0; i<dni.length; i++) {						
						aux = file.readChar();					
						dni[i] = aux;					
					}
					dniSalida = new String(dni).trim();
					
					for(int i=0; i<nombre.length; i++) {						
						aux = file.readChar();					
						nombre[i] = aux;					
					}
					nombreSalida = new String(nombre).trim();
					
					for(int i=0; i<identidad.length; i++) {						
						aux = file.readChar();					
						identidad[i] = aux;					
					}
					identidadSalida = new String(identidad).trim();
					
					for(int i=0; i<tipo.length; i++) {						
						aux = file.readChar();					
						tipo[i] = aux;					
					}
					tipoSalida = new String(tipo).trim();
					
					peso = file.readInt();
					altura = file.readInt();
					
					unPersonaje = new Personaje(dniSalida, nombreSalida, identidadSalida, tipoSalida, peso, altura);
					
					unArrayPersonajes.add(unPersonaje);
					
					posicion = (posicion+78) + 110;
					
				}else {
					posicion = posicion + 110;
				}			
						
			}
			
			if(cont==0) {
				System.out.println("No existe " + tipoConsola + " en el fichero.");
				
			}else {
				System.out.println("Se han encontrado " + cont + " " + tipoConsola + "s.");		
				for(int i=0; i<unArrayPersonajes.size(); i++) {
					System.out.println(unArrayPersonajes.get(i).toString());					
				}			
																				
			}			
			
			file.close();					
			
		}catch(FileNotFoundException e) {

		}

	}

}
