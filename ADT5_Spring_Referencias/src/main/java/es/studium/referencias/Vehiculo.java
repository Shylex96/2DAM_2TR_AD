package es.studium.referencias;

public class Vehiculo {
	private String marca;
	private String modelo;
	private Motor motor;

	public Vehiculo() {
		marca = "";
		modelo = "";
		motor = new Motor();
	}
	public Vehiculo(String marca, String modelo, Motor motor) {
		this.marca = marca;
		this.motor = motor;
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	@Override
	public String toString() {
		return "Vehículo [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + "]";
	}
}
