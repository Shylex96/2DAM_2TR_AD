package es.studium.hibernate;

import java.time.LocalDateTime;
import jakarta.persistence.*;

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

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", referencia=" + referencia + ", fecha=" +fecha + "]";
	}
}

