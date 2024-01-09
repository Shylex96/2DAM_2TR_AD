package es.studium.InyeccionDependencia;

public class VehiculoV3 {

	private IMotor m;
	
	public VehiculoV3(IMotor motorVehiculo) {
		
		m = motorVehiculo;
		
	}
	
	public int getRevolucionesMotor() {
		
		return m.getRevoluciones();
	}
}
