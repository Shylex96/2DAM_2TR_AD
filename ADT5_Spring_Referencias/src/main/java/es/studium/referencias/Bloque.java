package es.studium.referencias;

public class Bloque {
	
	private int cantidadCilindros;
	public Bloque() {
		cantidadCilindros = 0;
	}
	public Bloque(int cantidadCilindros) {
		this.cantidadCilindros = cantidadCilindros;
	}
	public int getCantidadCilindros() {
		return cantidadCilindros;
	}
	public void setCantidadCilindros(int cantidadCilindros) {
		this.cantidadCilindros = cantidadCilindros;
	}
	@Override
	public String toString() {
		return "Bloque [cantidadCilindros=" + cantidadCilindros + "]";
	}
}