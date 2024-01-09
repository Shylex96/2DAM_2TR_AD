package es.studium.autowiring;

public class Cliente {

	private long id;
	private Persona persona;
	
	public Cliente() {
		// ...
	}
	
	public Cliente(long id, Persona persona) {
		this.id = id;
		this.persona = persona;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", persona=" + persona + "]";
	}
}
