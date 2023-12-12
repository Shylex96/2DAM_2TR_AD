package es.studium.hibernate;

import java.time.LocalDateTime;
import java.util.List;
import es.studium.hibernate.dao.AlbaranDao;
import es.studium.hibernate.dao.FacturaDao;
import es.studium.hibernate.dao.PedidoDao;
import es.studium.hibernate.dao.ProductoDao;

public class Principal {

	public static void main(String[] args) {
		/* OPERACIONES CON PEDIDOS */
		/* Creamos Pedidos */
		PedidoDao pedidoDao = new PedidoDao();

		Pedido pedido = new Pedido();
		pedido.setFecha(LocalDateTime.now());
		pedido.setReferencia("001RefPedido");

		pedidoDao.save(pedido);

		List<Pedido> pedidos = pedidoDao.getAll();

		System.out.println("****Lista de pedidos: " + pedidos);

		/* Pedido creado con la fecha actual */
		Pedido pedido2 = new Pedido("001", LocalDateTime.now());
		pedidoDao.save(pedido2);

		/* Pedido creado con fecha de pasado mañana, 2 días más de la fecha actual */
//		Pedido pedido3 = new Pedido("pedidoFuturo", LocalDateTime.now().plus(2, ChronoUnit.DAYS));
//		pedidoDao.save(pedido3);

		/* Creamos un pedido de hace una semana. */
//		Pedido pedido4 = new Pedido("pedPas", LocalDateTime.now().minus(1, ChronoUnit.WEEKS));
//		pedidoDao.save(pedido4);

		/* EJERCICIO 1: OPERACIONES CON ALBARARES */
		System.out.println("EJERCICIO 1: OPERACIONES CON ALBARARES");
		/* Creamos Albaranes */
		AlbaranDao albaranDao = new AlbaranDao();

		Albaran albaran = new Albaran("004");
		albaranDao.save(albaran);

		List<Albaran> albaranes = albaranDao.getAll();
		System.out.println("****Listado de albaranes: " + albaranes);

		/* Modificamos albaranes */
		albaran.setReferencia("ALB-008");
		albaran.setPedido(pedido2);
		albaranDao.update(albaran);
		System.out.println("****Otro listado de albaranes: " + albaranes);

		/*
		 * Borramos albaranes. Primero lo creo, luego lo elimino. No se aprecia en la
		 * base de datos porque el mismo albarán que se ha creado, lo elimina después.
		 * Pero si creamos después un nuevo abarán, vemos que el id se ha incrementado.
		 */
		Albaran albaran2 = new Albaran("100");
		albaranDao.save(albaran2);
		albaranDao.delete(albaran2);
		System.out.println("Más listado de albaranes: " + albaranes);

		/* EJERCICIO 2: OPERACIONES CON FACTURAS */
		System.out.println("EJERCICIO 2: OPERACIONES CON FACTURAS");
		/* Creamos facturas */
		FacturaDao facturaDao = new FacturaDao();

		Factura factura = new Factura(pedido);
		facturaDao.save(factura);

		List<Factura> facturas = facturaDao.getAll();
		System.out.println("****Listado de facturas: " + facturas);

		/* Modificamos facturas. */
		factura.setNumero("FAC-122");
		factura.setPedido(pedido2);
		facturaDao.update(factura);
		System.out.println(factura);
		System.out.println("****Otro listado de facturas: " + facturas);

		/* EJERCICIO 3: OPERACIONES CON PRODUCTO */
		System.out.println("EJERCICIO 3: OPERACIONES CON PRODUCTOS");
		/* Creamos productos */
		ProductoDao productoDao = new ProductoDao();

		Producto producto = new Producto("ProdRef2", "Lecha entera");
		productoDao.save(producto);

		List<Producto> productos = productoDao.getAll();
		System.out.println("****Listado de productos: " + productos);

		/* Modificamos productos */
		producto.setDescripcion("Leche desnatada");
		productoDao.update(producto);
		System.out.println(producto);
		System.out.println("****Otro listado de productos: " + productos);
	}
}
