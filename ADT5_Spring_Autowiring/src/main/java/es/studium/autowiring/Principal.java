package es.studium.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {
	public static void main(String[] args) {
		/*Abrimos el contenedor de IoC indicando la ruta exacta de donde se encuentra el fichero beans.xml*/
		ApplicationContext appContext = new ClassPathXmlApplicationContext("es/studium/xml/beans.xml");
		/*Obtenemos un bean Cliente y observamos cómo se 
		 * inyectan las dependencias de forma automática.*/
		Cliente c1 = appContext.getBean("cliente", Cliente.class);
		System.out.println(c1);
		((ClassPathXmlApplicationContext) appContext).close();
	}
}