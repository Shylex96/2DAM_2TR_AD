package es.studium.referencias;

public class Motor {
	private double cilindrada;
	private Culata culata;
	private Bloque bloque;
	private Carter carter;
	
	public Motor() {
		cilindrada = 0.0;
		culata = new Culata();
		bloque = new Bloque();
		carter = new Carter();
	}
	public Motor(double cilindrada, Culata culata, Bloque bloque, Carter
			carter) {
		this.bloque = bloque;
		this.carter = carter;
		this.cilindrada = cilindrada;
		this.culata = culata;
	}
	public double getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(double cilindrada) {
		this.cilindrada = cilindrada;
	}
	public Culata getCulata() {
		return culata;
	}
	public void setCulata(Culata culata) {
		this.culata = culata;
	}
	public Bloque getBloque() {
		return bloque;
	}
	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}
	public Carter getCarter() {
		return carter;
	}
	public void setCarter(Carter carter) {
		this.carter = carter;
	}
	@Override
	public String toString() {
		return "Motor [cilindrada=" + cilindrada + ", bloque=" + bloque + ", culata=" + culata + ", carter= " + carter + "]";
	}
}

