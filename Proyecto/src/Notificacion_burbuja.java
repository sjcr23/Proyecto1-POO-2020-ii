import java.time.LocalDate;

public class Notificacion_burbuja extends Notificacion {
	
	private Burbuja burbujaSocial;

	public Notificacion_burbuja(Burbuja burbujaSocial, Persona paciente) {
		super(paciente);
		this.burbujaSocial = burbujaSocial;
	}

	@Override
	public String toString() {
		return super.mensaje + "\n";
	}
}

