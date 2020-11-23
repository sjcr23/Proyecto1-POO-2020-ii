import java.time.LocalDate;

public class Notificacion_recinto extends Notificacion {
	
	private Establecimiento recinto;

	public Notificacion_recinto(Establecimiento recinto, Persona paciente) {
		super();
		super.mensaje = "Positivo para Covid19";
		super.paciente =  paciente;
		super.fecha = LocalDate.now();
		this.recinto = recinto;
	}

	
}
