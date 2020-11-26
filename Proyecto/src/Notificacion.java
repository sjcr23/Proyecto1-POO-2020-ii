import java.time.LocalDate;

//Declaración de la clase abstracta 'Notificación'
public abstract class Notificacion {
	
	// Atributos
	protected String mensaje;
	protected LocalDate fecha;
	protected Persona paciente;
	
	// Método constructor
	public Notificacion(Persona paciente) {
		super();
		this.fecha = LocalDate.now();
		this.paciente = paciente;
	}
	
	
}
