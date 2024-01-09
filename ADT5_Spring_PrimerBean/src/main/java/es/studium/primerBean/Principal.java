package es.studium.primerBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {
	public static void main(String[] args) {
		//Establecemos la conexión con el contenedor de IoC
		ApplicationContext appContext = new ClassPathXmlApplicationContext("es/studium/xml/beans.xml");
		//Obtenemos un objeto bean Saludo y podemos hacerlo de tres formas diferentes.
		//1) Pasando como prámetro el id del bean que queremos obtener. Nos obliga a hacer un casting
		Saludo saludo = (Saludo) appContext.getBean("saludamos");
		//2) Pasando dos parámetros. El id y la clase del bean.
		Saludo saludo2 = appContext.getBean("saludamos", Saludo.class);
		//3) Pasando como parámetro la clase del bean. Salta una excepción si el bean está repetido
		//Saludo saludo3 = appContext.getBean(Saludo.class);
		//Obtenemos el valor del atributo del bean y lo mostramos por consola.
		System.out.println(saludo.getSaludo());
		//Cerramos el contenedor
		((ClassPathXmlApplicationContext) appContext).close();
	}
}

