package es.studium.hibernate;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "albaran")
public class Albaran {
	
	private static final String PREFIJO = "ALB-";
	/*No usamos la anotaci�n @Column en los atributos, porque generaremos las
	 * columnas de la tabla albaran con el mismo nombre que tienen los 
	 * atributos creados a continuaci�n:*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String referencia;
	
	private LocalDateTime fechaEmision;
	
	private LocalDateTime fechaRecepcion;
	
	/* Lazy: La carga de los objetos de la relaci�n se producen a demanda, es decir, 
	 * cuando un cliente los solicita.*/
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
	
	public Albaran() {
		id = 0;
		fechaEmision = LocalDateTime.now();
		/*La fecha de recepci�n del pedido se crear� en un momento posterior en el programa, 
		 * no al crear el Albar�n, por eso no podemos iniciar aqu� el atributo fechaRecepcion*/
		//fechaRecepcion	= LocalDateTime.now();
		pedido = new Pedido();
	}
	
	public Albaran(String refPedido) {
		referencia = PREFIJO + refPedido; //Prefijo de la referencia.
		fechaEmision = LocalDateTime.now();
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

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public LocalDateTime getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Albaran [id=" + id + ", referencia=" + referencia + ", fechaEmision=" + fechaEmision
				+ ", fechaRecepcion=" + fechaRecepcion + "]";
	}
}
