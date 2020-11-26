import java.time.LocalDate;
import java.util.ArrayList;

public class Notificacion_contacto extends Notificacion{
	
	private Dia registro_dia;

	public Notificacion_contacto(Dia diaActual, Persona paciente) {
		super(paciente);
		
		this.registro_dia = diaActual;
	}

	
	
	public void setMensaje() {
		String destinatarios = "";
		for(int i = 0; i < registro_dia.getClientes().size(); i++) {
			if(registro_dia.getClientes().get(i) == this.paciente) {
				continue;
			}
			destinatarios = destinatarios + "Para: " + registro_dia.getClientes().get(i).getNombre() + "\n"
					+ "se le informa que el día " + registro_dia.getFecha() + " usted tuvo contacto "
					+ " con una persona positiva de covid19\n"
					+ "por lo que se les recomienda extremar medidas preventitas y prestar atención a aparición de posibles síntomas\n\n";
		}
		

		
		super.mensaje = destinatarios;
		
		
	}
	@Override
	public String toString() {
		return super.mensaje + "\n";
	}
	
	
}
