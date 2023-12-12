package es.studium.hibernate.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("gestor");//nombre de la unidad de persistencia
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

	public static void main(String[] args) {
		EntityManager manager = getEntityManager();
		System.out.println("EntityManager class ==> " + manager.getClass().getName());
	}

}
