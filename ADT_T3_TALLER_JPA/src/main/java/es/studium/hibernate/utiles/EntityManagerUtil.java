package es.studium.hibernate.utiles;

import jakarta.persistence.*;

public class EntityManagerUtil {

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("gestor");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
	public static void main(String[] args) {
		EntityManager manager = EntityManagerUtil.getEntityManager();
		System.out.println("EntityManager class ==> " +
				manager.getClass().getName());
	}
}
