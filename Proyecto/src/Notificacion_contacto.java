import java.time.LocalDate;
import java.util.ArrayList;

public class Notificacion_contacto extends Notificacion{
	
	private ArrayList<Dia> registro_dia;

	public Notificacion_contacto(ArrayList<Dia> dia, Persona paciente) {
		super();
		super.mensaje = "Positivo para Covid19";
		super.fecha = LocalDate.now();
		super.paciente = paciente;
		this.registro_dia = new ArrayList<Dia>();
	}
	
	
}
