package ejercicios;

import java.io.*;

/*b). Desde la editorial quieren tener controlado el peso de sus personajes, ya que 
últimamente han hecho algún exceso que otro. Realiza un programa en java que te permita 
modificar los datos de un personaje. El programa recibe desde la línea de comandos el dni 
y el peso del último mes. Si el personaje no existe devolverá un mensaje de error, sino 
mostrará en la consola el nombre del personaje y cuantos kilos ha engordado, adelgazado 
o si se mantiene en su peso.*/

public class Ejercicio4b {

	public static void main(String[] args) {
				
		try {
			File fichero = new File("." + File.separator + "src" + File.separator + 
					"ejercicios" + File.separator + "Marvel.dat");
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			String dniConsola, dniFichero = null, nombreFichero = null;
			int pesoConsola, pesoFichero, posicion;
			char DNI[] = new char[9], aux;
			char Nombre[] = new char[10];			
			
			System.out.println("Intorduzca el DNI (con letra) del personaje para el control de peso: ");
			dniConsola = Consola.readString();
			posicion=4;
			
			while(!dniConsola.equals(dniFichero)) {
				file.seek(posicion);
				
				for(int i=0; i<DNI.length; i++) {						
					aux = file.readChar();					
					DNI[i] = aux;					
				}
				
				dniFichero = new String(DNI).trim();				
				posicion = posicion + 110;
				
				if(posicion > file.length())break;
				
			}
			
			if(!dniConsola.equals(dniFichero)) {
				System.out.println("no existe");				
			}else {
				System.out.println("Introduzca su peso actual: ");
				pesoConsola = Consola.readInt();
				
				file.seek(posicion-92);
				
				for(int i=0; i<Nombre.length; i++) {
					aux = file.readChar();
					Nombre[i] = aux;					
				}
				
				nombreFichero = new String(Nombre).trim();
				
				int salto = 60;
				
				file.skipBytes(salto);
				pesoFichero = file.readInt();
								
				if(pesoConsola == pesoFichero) {
					System.out.println(nombreFichero + " se mantiene en su peso anterior.");					
				}else if(pesoConsola > pesoFichero) {
					int diferencia = pesoConsola - pesoFichero;
					System.out.println(nombreFichero + " ha engordado " + diferencia + " kilos.");
					file.seek(posicion-12);
					file.writeInt(pesoConsola);
				}else if(pesoConsola < pesoFichero) {
					int diferencia = pesoFichero - pesoConsola;
					System.out.println(nombreFichero + " ha adelgazado " + diferencia + " kilos.");	
					file.seek(posicion-12);
					file.writeInt(pesoConsola);
				}	
				
			}
			
			file.close();	
			
			
		}catch(Exception ex) {
			
			System.out.println("algo no va bien: " + ex.getMessage());
		}
		
		

	}

}
