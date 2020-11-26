import java.time.LocalDate;

public class Notificacion_burbuja extends Notificacion {
	
	private Burbuja burbujaSocial;

	public Notificacion_burbuja(Burbuja burbujaSocial, Persona paciente) {
		super(paciente);
		this.burbujaSocial = burbujaSocial;
	}

	public void setMensaje() {
		String destinatarios = "Para: ";
		for(int i = 0; i < burbujaSocial.getPeronas().size(); i++) {
			if(burbujaSocial.getPeronas().get(i) == this.paciente) {
				continue;
			}
			destinatarios = destinatarios + burbujaSocial.getPeronas().get(i).getNombre() + ", ";
			
		}
		
		String mensaje = destinatarios + "\n\n" + "Se le informa a los miembros de la burbuja " + this.burbujaSocial.getid() +
				" que la persona " + this.paciente.getNombre() + "\nse ha contagiado de Covid19, por lo que se les solicita"
						+ " someterse a cuarentena obligatoria de 14 días\n";
		
		super.mensaje = mensaje;
		
		
	}
	
	@Override
	public String toString() {
		return super.mensaje;
	}
}

