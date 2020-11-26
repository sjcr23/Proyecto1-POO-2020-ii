import java.time.LocalDate;

public class Notificacion_recinto extends Notificacion {
	
	private Establecimiento recinto;

	public Notificacion_recinto(Establecimiento recinto, Persona paciente) {
		super(paciente);
		super.fecha = LocalDate.now();
		this.recinto = recinto;
	}
	
	public void setMensaje() {
		String destinatarios = "Para: ";
		for(int i = 0; i < recinto.getTrabajadores().size(); i++) {
			if(recinto.getTrabajadores().get(i) == this.paciente) {
				continue;
			}
			destinatarios = destinatarios + recinto.getTrabajadores().get(i).getNombre() + ", ";
			
		}
		
		String mensaje = destinatarios + "\n\n" + "Se le informa a los compañeros y las compañeras del establecimiento " + this.recinto.getNombre() +
				" que la persona " + this.paciente.getNombre() + "\nse ha contagiado de Covid19, por lo que se les recomienda\n"
						+ "extremar medidas preventitas y prestar atención a aparición de posibles síntomas\n";
		
		super.mensaje = mensaje;
		
		
	}
	@Override
	public String toString() {
		return super.mensaje + "\n";
	}
	
	

	
}
