package es.studium.referencias;

public class Carter {
	private double volumenAceite;

	public Carter() {
		volumenAceite = 0.0;
	}
	public Carter(double volumenAceite) {
		this.volumenAceite = volumenAceite;
	}
	public double getVolumenAceite() {
		return volumenAceite;
	}
	public void setVolumenAceite(double volumenAceite) {
		this.volumenAceite = volumenAceite;
	}
	@Override
	public String toString() {
		return "Cárter [volumenAceite=" + volumenAceite + "]";
	}
}
