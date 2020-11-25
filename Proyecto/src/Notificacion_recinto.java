import java.time.LocalDate;

public class Notificacion_recinto extends Notificacion {
	
	private Establecimiento recinto;

	public Notificacion_recinto(Establecimiento recinto, Persona paciente) {
		super(paciente);
		super.fecha = LocalDate.now();
		this.recinto = recinto;
	}

	@Override
	public String toString() {
		return super.mensaje + "\n";
	}
	
	

	
}
