package es.studium.hibernate.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import es.studium.hibernate.utiles.EntityManagerUtil;
import jakarta.persistence.*;

public abstract class AbstractDao<T> implements Dao<T> {
	
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();
	private Class<T> clazz;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Optional<T> get(int id) {
		return Optional.ofNullable(entityManager.find(clazz, id));
	}

	@Override
	public List<T> getAll() {
		String qlString = "FROM " + clazz.getName();
		Query query = entityManager.createQuery(qlString);
		return query.getResultList();
	}

	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			action.accept(entityManager);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

	@Override
	public void save(T t) {
		executeInsideTransaction(entityManager -> entityManager.persist(t));
	}

	@Override
	public void update(T t) {
		executeInsideTransaction(entityManager -> entityManager.merge(t));
	}

	@Override
	public void delete(T t) {
		executeInsideTransaction(entityManager -> entityManager.remove(t));
	}
}
