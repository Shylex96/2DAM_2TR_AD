package biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.matisse.MtDatabase;
import com.matisse.MtException;
import com.matisse.MtObjectIterator;

public class Principal {

	public static void main(String[] args) {
		String hostname = "localhost";
		String dbname = "biblioteca";

		//	creaObjetos(hostname, dbname);
		//	borrarTodos(hostname, dbname);
		//modificaObjeto(hostname, dbname, "Haruki", 35);
		//borraObjetos(hostname, dbname);
		ejecutaOQL(hostname, dbname);
	}

	public static void creaObjetos(String hostname, String dbname) {
		try {
			// Abre la base de datos con el hostname (localhost), y el nombre de lla base de
			// datos dbname (biblioteca).
			MtDatabase db = new MtDatabase(hostname, dbname);
			db.open();
			db.startTransaction();
			System.out.println("Conectado a la base de datos " + db.getName() + " de Matisse");
			// Crea un objeto Autor
			Autor a1 = new Autor(db);
			a1.setNombre("Haruki");
			a1.setApellidos("Murakami");
			a1.setEdad(53);
			System.out.println("Objeto de tipo Autor creado.");
			// Crea un objeto Libro
			Libro l1 = new Libro(db);
			l1.setTitulo("Baila Baila Baila");
			l1.setEditorial("TusQuests");
			l1.setPaginas(512);
			// Crea otro objeto libro
			Libro l2 = new Libro(db);
			l2.setTitulo("Tokio Blues");
			l2.setEditorial("TusQuests");
			l2.setPaginas(498);
			System.out.println("Objetos de tipo Libro creados.");
			// Crea un array de Obras para guardar los libros y hacer las relaciones
			Obra o1[] = new Obra[2];
			o1[0] = l1;
			o1[1] = l2;
			// Guarda las relaciones del autor con los libros que ha escrito.
			a1.setEscribe(o1);
			// Ejecuta un commit para materializar las peticiones.
			db.commit();
			// Cierra la base de datos.
			db.close();
			System.out.println("\nHecho.");
		} catch (MtException mte) {
			System.out.println("MtException : " + mte.getMessage());
		}
	}

	public static void borraObjetos(String hostname, String dbname)
	{
		try
		{
			/*
			 * Abre la base de datos con el hostname (localhost) y el nombre de la
			 * base de datos dbname (biblioteca).
			 */
			MtDatabase db = new MtDatabase(hostname, dbname);
			db.open();
			db.startTransaction();
			System.out.println("Conectado a la base de datos " + db.getName() + " de Matisse.");
			/*
			 * El método getInstanceNumber(db) cuenta el número de objetos del
			 * tipo de la clase con la que lo llamemos que en este caso es Obra
			 */
			System.out.println("\n" + Obra.getInstanceNumber(db) + " objetos de tipo Obra tenemos en la DB.");
			// Crea un Iterador (propio de Java)
			MtObjectIterator<Obra> iter = Obra.<Obra>instanceIterator(db);
			System.out.println("Borro dos objetos de tipo Obra");
			while (iter.hasNext())
			{
				Obra[] obras = iter.next(2);
				System.out.println("Borrando " + obras.length + " objetos de tipo Obra.");
				for (int i = 0; i < obras.length; i++)
				{
					// Borra el objeto
					obras[i].deepRemove();
				}
				// Solo borra 2 objetos y sale del bucle.
				break;
			}
			iter.close();
			db.commit();
			db.close();
			System.out.println("\nObjetos borrados correctamente en la base de datos.");
		}
		catch (MtException mte)
		{
			System.out.println("MtException : " + mte.getMessage());
		}
	}

	// Borrar todos los objetos de una clase
	public static void borrarTodos(String hostname, String dbname) {
		System.out.println("====================== Borrar Todos =====================\n");
		try {
			MtDatabase db = new MtDatabase(hostname, dbname);
			db.open();
			db.startTransaction();
			System.out.println("Conectado a la base de datos " + db.getName() + " de Matisse.");
			/*
			 * El método getInstanceNumber(db) cuenta el número de objetos del tipo de la
			 * clase con la que lo llamemos que en este caso es Obra
			 */
			System.out.println("\n" + Obra.getInstanceNumber(db) + " objetos de tipo Obra tenemos en la DB.");
			// Borra todas las instancias de Obra
			Obra.getClass(db).removeAllInstances();
			// Materializa los cambios y cierra la BD
			db.commit();
			db.close();
			System.out.println("\nTodos los objetos de tipo Obra eliminados correctamente de la base de datos.");
		} catch (MtException mte) {
			System.out.println("MtException : " + mte.getMessage());
		}
	}

	public static void modificaObjeto(String hostname, String dbname, String nombre, Integer nuevaEdad) {
		System.out.println("=========== Modifica un objeto ==========\n");
		int nAutores = 0;
		try {
			MtDatabase db = new MtDatabase(hostname, dbname);
			db.open();
			db.startTransaction();
			System.out.println("Conectado a la base de datos " + db.getName() + " de Matisse.");
			/*
			 * El método getInstanceNumber(db) cuenta el número de objetos del tipo de la
			 * clase con la que lo llamemos que en este caso es Autor.
			 */
			System.out.println("\n" + Autor.getInstanceNumber(db) + " objetos de tipo Autor tenemos en la DB.");

			nAutores = (int) Autor.getInstanceNumber(db);
			// Crea un Iterador (propio de Java)
			MtObjectIterator<Autor> iter = Autor.<Autor>instanceIterator(db);
			System.out.println("\nRecorro el iterador de uno en uno y cambio cuando encuentro 'nombre'");
			while (iter.hasNext()) {
				Autor[] autores = iter.next(nAutores);
				for (int i = 0; i < autores.length; i++) {
					/*
					 * Si el nombre del Autor coincide con el parámetro nombre pasado al método, le
					 * establecemos el parámetro edad que le pasamos al método.
					 */
					if (autores[i].getNombre().compareTo(nombre) == 0) {
						autores[i].setEdad(nuevaEdad);
					} else {
						System.out.println("No se ha encontrado ningún Autor de nombre " + nombre
								+ " en la base de datos " + db.getName() + ".");
					}
				}
			}
			iter.close();
			// Materializa los cambios y cierra la BD
			db.commit();
			db.close();
			System.out.println("\nLa modificación del objeto, finalizada correctamrnte.");
		} catch (MtException mte) {
			System.out.println("MtException : " + mte.getMessage());
		}
	}

	public static void ejecutaOQL(String hostname, String dbname) {
		MtDatabase dbcon = new MtDatabase(hostname, dbname);
		// Abre una conexión a la base de datos
		dbcon.open();
		try {
			// Crea una instancia de Statement
			Statement stmt = dbcon.createStatement();
			/*
			 * Asigna una consulta OQL. Esta consulta lo que hace es utilizar REF() para
			 * obtener el objeto directamente. biblioteca2020.Autor es el mapeo a la clase
			 * Autor. Es decir biblioteca2020 es el paquete en el que tenemos la clase
			 * Autor.
			 */
			String commandText = "SELECT REF(a) from biblioteca.Autor a;";
			/*
			 * Ejecuta la consulta y obtiene un ResultSet que contendrá las referencias a
			 * los objetos que en este caso serán de tipo Autor.
			 */
			ResultSet rset = stmt.executeQuery(commandText);
			/*
			 * Creamos una referencia a un objeto de tipo Autor donde almacenaremos los
			 * objetos devueltos en el ResultSet.
			 */
			Autor a1;
			// Recorremos el ResultSet.
			while (rset.next()) {
				/*
				 * Con el método getObject() recuperamos cada objeto del ResultSet y lo
				 * almacenamos en a1. El casteo es necesario porque el método getObject devuelve
				 * un tipo Object.
				 */
				a1 = (Autor) rset.getObject(1);
				/*
				 * Una vez el objeto es referenciado en a1, ya se pueden recuperar de él los
				 * valores de sus atributos.
				 */
				System.out.println("Los valores de los atributos del objeto de tipo Autor son: " + a1.getNombre() + " "
						+ a1.getApellidos() + " " + a1.getEdad() + ".");
			}
			/*
			 * Cierra las conexiones. Solamente debemos cerrar el ResultSet y el Statement,
			 * no el MtDatabase porque lanza una excepción de que no conoce la fuente.
			 */
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		} 
		/*	finally {
			try {
				dbcon.close();
			} catch (MtException e) {
				System.out.println("Error al cerrar la conexión: " + e.getMessage());
			}
	}
		 */
	}
}
