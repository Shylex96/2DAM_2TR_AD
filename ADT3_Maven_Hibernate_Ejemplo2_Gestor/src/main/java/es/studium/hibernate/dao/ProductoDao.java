package es.studium.hibernate.dao;

import es.studium.hibernate.Producto;

public class ProductoDao extends AbstractDao<Producto> {
	public ProductoDao() {
		setClazz(Producto.class);
	}
}
