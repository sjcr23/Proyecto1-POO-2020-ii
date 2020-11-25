import java.time.LocalDate;

public abstract class Notificacion {
	
	protected String mensaje;
	protected LocalDate fecha;
	protected Persona paciente;
	
	public Notificacion(Persona paciente) {
		super();
		this.fecha = LocalDate.now();
		this.paciente = paciente;
	}
	
	
}
