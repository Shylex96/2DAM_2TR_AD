package es.studiun.mongodb;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class MongoDB {

    public static void main(String[] args) {
        MongoCRUD mongoCrud = new MongoCRUD();

        System.out.println("INICIANDO EL PROGRAMA DE MONGODB CON LOS MÉTODOS DEL CRUD\n");
        
        // Obtener la colección
        MongoCollection<Document> alumnos = mongoCrud.getCollection();

        // Crear documentos
        mongoCrud.crear(alumnos);

        // Consultar documentos
        mongoCrud.consultar(alumnos);

        // Actualizar documentos
        mongoCrud.actualizarDocumentos(alumnos);

        // Eliminar documentos
        mongoCrud.eliminarDocumentos(alumnos);

        mongoCrud.closeConnection();
    }
}
