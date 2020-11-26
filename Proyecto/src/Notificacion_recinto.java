import java.time.LocalDate;

//Declaración de la clase hija 'Notificacion_recinto' que extiende de 'Notificación'
public class Notificacion_recinto extends Notificacion {
	
	//Atributos
	private Establecimiento recinto;

	//Constructor
	public Notificacion_recinto(Establecimiento recinto, Persona paciente) {
		
		//Constructor de la clase madre
		super(paciente);
		
		super.fecha = LocalDate.now();
		this.recinto = recinto;
	}
	
	//Genera el mensaje de Notificacion_recinto
	public void setMensaje() {
		//Variables
		String destinatarios = "Para: ";
		
		//Recorre el átributo 'Recinto' para encontrar los destinatarios del mensaje
		for(int i = 0; i < recinto.getTrabajadores().size(); i++) {
			
			//Si encuentra al contagiado no lo agrega a los destinatarios
			if(recinto.getTrabajadores().get(i) == this.paciente) {
				
				continue;
			}
			
			destinatarios = destinatarios + recinto.getTrabajadores().get(i).getNombre() + ", ";
			
		}
		
		//Mensaje con los destinatarios encontrados
		String mensaje = destinatarios + "\n\n" + "Se le informa a los compañeros y las compañeras del establecimiento " + this.recinto.getNombre() +
				" que la persona " + this.paciente.getNombre() + "\nse ha contagiado de Covid19, por lo que se les recomienda\n"
						+ "extremar medidas preventitas y prestar atención a aparición de posibles síntomas\n";
		
		//Modifica el átributo mensaje, de la clase madre, de esta instancia
		super.mensaje = mensaje;
		
		
	}
	@Override
	//Retorna el mensaje que de la notifiación
	public String toString() {
		return super.mensaje + "\n";
	}
	
	

	
}
