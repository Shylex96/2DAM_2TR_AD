package es.studium.hibernate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
	
	private static final String PREFIJO = "FAC-";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String numero;
	
	@OneToOne 
	@JoinColumn
	private Pedido pedido;
	
	public Factura() {
	}
	public Factura(Pedido pedido) {
		this.numero = PREFIJO + pedido.getReferencia();
		this.pedido = pedido;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	@Override
	public String toString() {
		return "Factura [id=" + id + ", numero=" + numero + "]";
	}
}
