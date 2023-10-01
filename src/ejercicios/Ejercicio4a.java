package ejercicios;

import java.io.*;

/*Desde la editorial Marvel te han contratado para hacer una aplicación que gestione los 
datos de sus superhéroes y supervillanos. Para almacenar la información han decidido 
utilizar ficheros de distintas clases

a). Realiza un programa en java para guardar datos de personajes en un fichero aleatorio, 
dale el nombre Marvel.dat. Introduce la información de los personajes a partir de los arrays 
que se te proporcionan en la plataforma Moodle. Cuando termine de realizar la carga de 
datos deberá informar al usuario de que la carga se ha realizado satisfactoriamente o no. 
*/

public class Ejercicio4a {

	public static void main(String[] args) throws IOException {
		final int longitudRegistro = 110;
		File fichero = new File("." + File.separator + "src" + File.separator + 
				"ejercicios" + File.separator + "Marvel.dat");
		if(fichero.exists()) {
			fichero.delete();
		}	
	
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		//Arrays de los personajes de marvel proporcionados para la tarea.
		int [] ids= {1, 2, 3, 4, 5, 6, 7};
		String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
		String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
		String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
		String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
		int[] pesos = {76,84,66,136,78,102,70};
		int[] alturas = {178,183,156,152,177,182,188};
		
		StringBuffer bufferDNI;
		StringBuffer bufferNombre;
		StringBuffer bufferIdentidad;
		StringBuffer bufferTipo; 
		int cuantos = dnis.length;
		int posicion = 0;
		
		for(int i=0; i<cuantos; i++) {
			posicion = i*longitudRegistro;
			file.seek(posicion);
			
			file.writeInt(ids[i]);
			
			bufferDNI = new StringBuffer(dnis[i]);
			bufferDNI.setLength(9);
			file.writeChars(bufferDNI.toString());
			
			bufferNombre = new StringBuffer(noms[i]);
			bufferNombre.setLength(10);
			file.writeChars(bufferNombre.toString());
			
			bufferIdentidad = new StringBuffer(identidades[i]);
			bufferIdentidad.setLength(20);
			file.writeChars(bufferIdentidad.toString());
			
			bufferTipo = new StringBuffer(tipos[i]);
			bufferTipo.setLength(10);
			file.writeChars(bufferTipo.toString());
			
			file.writeInt(pesos[i]);
			file.writeInt(alturas[i]);
		}
		
		file.close();
		System.out.println("La carga de los personajes ha terminado correctamente.");
	
		
	}

}
