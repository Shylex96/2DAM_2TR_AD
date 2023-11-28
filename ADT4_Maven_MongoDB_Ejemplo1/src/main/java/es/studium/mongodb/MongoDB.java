package es.studium.mongodb;

import java.util.Arrays;

import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class MongoDB {
	private static MongoClient mongoClient;
	
	public static void main(String[] args) {
		MongoClient conexion = MongoClients.create("mongodb://localhost:27017");
		mongoClient = conexion;
		
		MongoDatabase database = conexion.getDatabase("ad");
		MongoCollection<Document> alumnos = database.getCollection("studium");

		/* INSERTAR DOCUMENTOS */
		// Creamos un documento mediante new
		Document documento = new Document("nombre", "Manolo").append("apellido", "García").append("edad", 28);
		// Añadimos un único documento
		alumnos.insertOne(documento);
		// Insertamos varios documentos creados parseando strings
		alumnos.insertMany(Arrays.asList(
				Document.parse("{ nombre: 'Ana', edad: 25, pagado: true, nota: 7 }"),
				Document.parse("{ nombre: 'Benito', apellido: 'Benítez', edad: 50, nota: 9.8 }"),
				Document.parse("{ nombre: 'Carmen', edad: 31, pagado: false, nota: 3 }")));

		/* BUSCAR DOCUMENTOS */
		// Buscar todos los alumnos
		FindIterable<Document> buscaTodos = alumnos.find();
		// Recorremos todos los documentos encontrados y mostramos sus valores
		for (Object alumno : buscaTodos) {
			System.out.println(((Document) alumno).toJson());
		}

		// Buscar todos los alumnos llamados "Ana". El operador eq es igual que.
		FindIterable<Document> buscaAna = alumnos.find(Filters.eq("nombre", "Ana"));
		for (Object alumno : buscaAna) {
			System.out.println(((Document) alumno).toJson());
		}

		// Buscar todos los alumnos que han suspendido (lte método menor o igual que).
		FindIterable<Document> busquedaSuspendidos = alumnos.find(Filters.lte("nota", 5));
		for (Object alumno : busquedaSuspendidos) {
			System.out.println(((Document) alumno).toJson());
		}

		// Buscar todos los alumnos llamados Ana que han aprobado.
		FindIterable<Document> buscaAnaAprobados = alumnos
				.find(Filters.and(Filters.lte("nombre", "Ana"), Filters.gte("nota", 5)));
		for (Object alumno : buscaAnaAprobados) {
			System.out.println(((Document) alumno).toJson());
		}

		/* ACTUALIZAR UN DOCUMENTO */
		alumnos.updateOne(Filters.eq("nombre", "Ana"),
				Updates.combine(Updates.set("apellido", "Andrea"), Updates.set("nota", 8)));

		/* Para ver si se han actualizado correctamente un documento, recorremos
           la lista de Ana aprobados: */
		System.out.println("\nRECORREMOS ANA APROBADOS DESPUÉS DE ACTUALIZAR EL DOCUMENTO\n");
		for (Object alumno : buscaAnaAprobados) {
			System.out.println(((Document) alumno).toJson());
		}

		/* ELIMINAR DOCUMENTOS */
		/* Consultamos la base de datos y que nos muestre todos los
           documentos con nombre igual a Carmen */
		FindIterable<Document> buscaCarmen = alumnos.find(Filters.lte("nombre", "Carmen"));
		for (Object alumno : buscaCarmen) {
			System.out.println(((Document) alumno).toJson());
		}

		alumnos.deleteOne(Filters.eq("nombre", "Carmen"));

		/* Consultamos la base de datos y recorremos la colección para
           comprobar que se ha eliminado el primer documento de nombre Carmen */
		System.out.println("\nMOSTRAMOS LOS ALUMNOS CARMEN DESPUÉS DE ELIMINAR UNO\n");
		for (Object alumno : buscaCarmen) {
			System.out.println(((Document) alumno).toJson());
		}
		closeConnection();
	}

	private static  void closeConnection() {
		if (mongoClient != null) {
			mongoClient.close();
			System.out.println("\n # Connection to MongoDB closed #");
		}
	}
}
