package es.studium.referencias;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {
	public static void main(String[] args) {
		/*Abrimos el contenedor de IoC indicando la ruta exacta del fichero
beans.xml (Inyección de dependencia vía setter o property)*/
		ApplicationContext appContext = new
				ClassPathXmlApplicationContext("es/studium/xml/beans.xml");
		/*Obtenemos dos beans Vehiculo*/
		Vehiculo v1 = (Vehiculo) appContext.getBean("vehiculo");
		v1.setMarca("Seat");
		v1.setModelo("Marbella");
		System.out.println(v1);
		Vehiculo v2 = appContext.getBean("vehiculo", Vehiculo.class);
		v2.setMarca("Porsche");
		v2.setModelo("911");
		System.out.println(v2);
		((ClassPathXmlApplicationContext) appContext).close();
	}
}