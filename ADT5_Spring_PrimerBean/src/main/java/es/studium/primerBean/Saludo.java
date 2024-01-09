package es.studium.primerBean;

public class Saludo {
	
	private String saludo;
	
	public Saludo() {
		saludo = "";
	}
	
	public Saludo(String saludo) {
		this.saludo = saludo;
	}
	
	public String getSaludo() {
		return saludo;
	}
	
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
}
