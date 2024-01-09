package es.studium.autowiring;

public class Persona {

	private String nombre;
	private Ciudad ciudad;
	
	public Persona() {
		// ...
	}
	
	public Persona(String nombre, Ciudad ciudad) {
		this.nombre = nombre;
		this.ciudad = ciudad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Ciudad getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", ciudad=" + ciudad + "]";
	}
}