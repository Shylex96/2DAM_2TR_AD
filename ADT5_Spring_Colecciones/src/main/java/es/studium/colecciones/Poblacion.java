package es.studium.colecciones;

public class Poblacion {
	
	private String nombre;
	private int cantidadHabitantes;
	
	public Poblacion() {
		nombre = "";
		cantidadHabitantes = 0;
	}
	
	public Poblacion(String nombre, int cantidadHabitantes) {
		this.nombre = nombre;
		this.cantidadHabitantes = cantidadHabitantes;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantidadHabitantes() {
		return cantidadHabitantes;
	}
	
	public void setCantidadHabitantes(int cantidadHabitantes) {
		this.cantidadHabitantes = cantidadHabitantes;
	}
	@Override
	public String toString() {
		return "Población [nombre=" + nombre + ", cantidadHabitantes=" +
				cantidadHabitantes + "]";
	}
}