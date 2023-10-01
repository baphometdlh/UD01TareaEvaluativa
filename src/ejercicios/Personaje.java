package ejercicios;

public class Personaje {
	
	//atributos
	String dni, nombre, identidad, tipo;
	int peso, altura;
	
	//getter setter
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentidad() {
		return identidad;
	}
	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
	//constructor
	public Personaje(String dni, String nombre, String identidad, String tipo, int peso, int altura) {
		this.dni = dni;
		this.nombre = nombre;
		this.identidad = identidad;
		this.tipo = tipo;
		this.peso = peso;
		this.altura = altura;		
	}
	@Override
	public String toString() {
		return "Personaje [dni=" + dni + ", nombre=" + nombre + ", identidad=" + identidad + ", tipo=" + tipo
				+ ", peso=" + peso + ", altura=" + altura + "]";
	}


}
