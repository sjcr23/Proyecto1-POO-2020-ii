import java.time.LocalDate;
import java.util.ArrayList;

public class Notificacion_contacto extends Notificacion{
	
	private ArrayList<Dia> registro_dia;

	public Notificacion_contacto(Dia diaActual, Persona paciente) {
		super(paciente);
		
		this.registro_dia = new ArrayList<Dia>();
	}

	@Override
	public String toString() {
		return super.mensaje + "\n";
	}
	
	
}
