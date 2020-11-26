
//Declaración de la clase hija 'Notificacion_burbuja' que extiende de 'Notificación'
public class Notificacion_burbuja extends Notificacion {
	
	//Atributos
	private Burbuja burbujaSocial;

	//Constructor
	public Notificacion_burbuja(Burbuja burbujaSocial, Persona paciente) {
		
		//Constructor de la clase madre
		super(paciente);
		
		this.burbujaSocial = burbujaSocial;
	}

	//Genera el mensaje de Notificacion_burbuja
	public void setMensaje() {
		//Variables
		String destinatarios = "Para: ";
		
		//Recorre el átributo 'Burbuja Social' para encontrar los destinatarios del mensaje
		for(int i = 0; i < burbujaSocial.getPeronas().size(); i++) {
			
			//Si encuentra al contagiado no lo agrega a los destinatarios
			if(burbujaSocial.getPeronas().get(i) == this.paciente) {
				
				continue;
			}
			
			destinatarios = destinatarios + burbujaSocial.getPeronas().get(i).getNombre() + ", ";
			
		}
		
		//Mensaje con los destinatarios encontrados
		String mensaje = destinatarios + "\n\n" + "Se le informa a los miembros de la burbuja " + this.burbujaSocial.getid() +
				" que la persona " + this.paciente.getNombre() + "\nse ha contagiado de Covid19, por lo que se les solicita"
						+ " someterse a cuarentena obligatoria de 14 días\n";
		
		
		//Modifica el átributo mensaje, de la clase madre, de esta instancia
		super.mensaje = mensaje;
		
		
	}
	
	@Override
	//Retorna el mensaje que de la notifiación
	public String toString() {

		return super.mensaje;
	}
}
