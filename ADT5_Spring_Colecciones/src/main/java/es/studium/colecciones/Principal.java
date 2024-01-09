package es.studium.colecciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {
	public static void main(String[] args) {
		/*Abrimos el contenedor de IoC indicando la ruta exacta del fichero beans2.xml 
		 * donde tenemos la inyección de dependencias vía constructor*/
		ApplicationContext appContext = new ClassPathXmlApplicationContext("es/studium/xml/beans.xml");

		/*Obtenemos un bean Provincia y lo mostramos por consola*/
		/*En este caso imprime los valores, por defecto, de los atributos
		que le damos en el fichero beans2.xml*/
		Provincia p1 = appContext.getBean("Sevilla", Provincia.class);
		System.out.println(p1);

		/*Obtenemos dos beans Poblacion y lo añadimos a una lista*/
		Poblacion pob1 = appContext.getBean("DosHermanas",
				Poblacion.class);
		pob1.setNombre("Dos Hermanas");
		pob1.setCantidadHabitantes(10235);

		Poblacion pob2 = appContext.getBean("SevillaCapital",
				Poblacion.class);
		pob2.setNombre("Sevilla Capital");
		pob2.setCantidadHabitantes(706676);

		List<Poblacion> poblaciones = new ArrayList<Poblacion>();
		poblaciones.add(pob1);
		poblaciones.add(pob2);
		/*Imprimimos la lista de Poblaciones*/
		System.out.println(poblaciones);

		/*Creamos una segunda provincia */
		Provincia p2 = appContext.getBean("Sevilla", Provincia.class);
		p2.setNombre("Provincia de Sevilla");
		p2.setPoblaciones(poblaciones);
		System.out.println(p2);
		((ClassPathXmlApplicationContext) appContext).close();
	}
}