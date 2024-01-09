package es.studium.InyeccionDependencia;

public class Principal {

	public static void main(String[] args) {
		
		/* Estamos inyectando la dependencia, al pasar como parámetro del 
		 * constructor de la clase VehiculoV3 la instancia de un objeto 
		 * de la clase MotorDiesel que implementa la interfaz Motor */
		
		VehiculoV3 cocheDiesel1 = new VehiculoV3(new MotorDiesel());
		VehiculoV3 cocheGasolina1 = new VehiculoV3(new MotorGasolina());
		
		// Otra forma de hacerlo lo mismo que arriba usando Polimorfismo:
		IMotor coche1 = new MotorDiesel();
		VehiculoV3 cocheDiesel2 = new VehiculoV3(coche1);
	}
}
