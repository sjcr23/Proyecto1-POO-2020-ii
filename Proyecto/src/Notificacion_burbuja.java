import java.time.LocalDate;

public class Notificacion_burbuja extends Notificacion {
	
	private Burbuja burbujaSocial;

	public Notificacion_burbuja(Burbuja burbujaSocial, Persona paciente) {
		super();
		super.mensaje = "Positivo para Covid19";
		super.fecha = LocalDate.now();
		super.paciente = paciente;
		this.burbujaSocial = burbujaSocial;
	}
}
