package es.studium.autowiring;

public class Ciudad {
	
	private String nombre;
	
	public Ciudad() {
		// ....
	}
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + "]";
	}
}