package es.studium.hibernate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "pedido")
public class Pedido {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "referencia")
	private String referencia;
	
	@Column(name = "fecha")
	private LocalDateTime fecha;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Albaran> albaranes = new ArrayList<Albaran>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Factura factura;
	
	@ManyToMany(mappedBy = "pedidos", cascade = CascadeType.ALL)
	private Set<Producto> productos = new HashSet<Producto>();
	
	public Pedido() {
		id = 0;
		referencia = "";
		fecha = LocalDateTime.now();
	}
	
	public Pedido(String referencia, LocalDateTime fecha) {
		this.referencia = referencia;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	public List<Albaran> getAlbaranes() {
		return albaranes;
	}
	public void setAlbaranes(List<Albaran> albaranes) {
		this.albaranes = albaranes;
	}
	public Albaran generaAlbaran() {
		Albaran albaran = new Albaran(referencia);
		albaranes.add(albaran);
		return albaran;
	}

	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Factura generaFactura() {
		factura = new Factura(this);
		return factura;
	}

	public Set<Producto> getProductos() {
		return productos;
	}
	/*Comentamos el método setProductos porque lo estamos añadiendo desde el
	 * método addProducto*/
//	public void setProductos(Set<Producto> productos) {
//		this.productos = productos;
//	}
	public void addProducto(Producto producto) {
		productos.add(producto);
		if (!producto.getPedidos().contains(this)) {
			producto.addPedido(this);
		}
	}

	@Override
	public String toString() {
		System.out.println("LISTADO DE PEDIDOS");
		
		return "Pedido [id=" + id + ", referencia=" + referencia + ", fecha=" + fecha + ", albaranes=" + albaranes
				+ ", factura=" + factura + ", productos=" + productos + "]";
	}
}
