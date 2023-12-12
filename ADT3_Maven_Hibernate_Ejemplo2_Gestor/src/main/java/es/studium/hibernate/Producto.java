package es.studium.hibernate;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table (name = "producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String referencia;
	private String descripcion;
	
	@ManyToMany
	private Set<Pedido> pedidos = new HashSet<Pedido>();
	
	
	public Producto() {
	}
	
	public Producto(String referencia, String descripcion) {
		this.referencia = referencia;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Set<Pedido> getPedidos() {
		return pedidos;
	}
	/*Comentamos el método setPedidos porque lo estamos añadiendo desde el
	 * método addPedido*/
//	public void setPedidos(Set<Pedido> pedidos) {
//		this.pedidos = pedidos;
//	}
	public void addPedido(Pedido pedido) {
   		pedidos.add(pedido);
   		if (!pedido.getProductos().contains(this)) {
			pedido.addProducto(this);
		}
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", referencia=" + referencia + ", descripcion=" + descripcion + "]";
	}
}
