package es.studium.hibernate.dao;

import es.studium.hibernate.Factura;

public class FacturaDao extends AbstractDao<Factura> {
	public FacturaDao() {
		setClazz(Factura.class);
	}
}
