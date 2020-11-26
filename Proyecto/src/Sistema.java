import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
// Declaración de la clase 'Sistema'
public class Sistema{
	// Argumentos: El sistema tiene ArrayList de distintas clases (Persona,Establecimineto,Burbuja)
	private ArrayList<Persona> personas;
	private ArrayList<Establecimiento> establecimientos;
	private ArrayList<Burbuja> burbujas;
	private Dia DiaActual;
	// Método constructor
	public Sistema() {
		super();
		this.personas = new ArrayList<Persona>();
		this.establecimientos = new ArrayList<Establecimiento>();
		this.burbujas = new ArrayList<Burbuja>();
	}
	
	// Se añade al atributo el parámetro de la función
	public void añadirPersonas(Persona nuevaPersona) {
		personas.add(nuevaPersona);	
	}
	
	// Se añade al atributo el parámetro de la función
	public void añadirEstablecimiento(Establecimiento nuevoEstablecimiento) {
		establecimientos.add(nuevoEstablecimiento);
	}
	
	// Se añade al atributo el parámetro de la función
	public void añadirBurbuja(Burbuja nuevaBurbuja) {
		burbujas.add(nuevaBurbuja);
	}
	
	// Se añade al atributo el parámetro de la función
	public void setDia(Dia dia) {
		this.DiaActual = dia;
	}
	
	// Devuelve el ArrayList correspondiente al atributo
	public ArrayList<Persona> getPersonas(){
		return personas;
	}
	
	// Devuelve el ArrayList correspondiente al atributo
	public ArrayList<Establecimiento> getEstablecimientos(){
		return establecimientos;
	}
	
	// Devuelve el ArrayList correspondiente al atributo
	public ArrayList<Burbuja> getBurbujas(){
		return burbujas;
	}

	public void notificarContagio(Sistema sistema, Persona paciento) {
		// Declaración de variables
		ArrayList<Burbuja> listaBurbujas = sistema.getBurbujas();
		ArrayList<Establecimiento> listaEstablecimientos = sistema.getEstablecimientos();
		ArrayList<Dia> registro;
		Notificacion_burbuja notificacion1;
		Notificacion_recinto notificacion2;
		Notificacion_contacto notificacion3;
		
		// Se recorre toda la lista de Burbujas.
		for(int i = 0; i < listaBurbujas.size() ; i++) {
			// Si el atributo 'burbuja' del paciente == al atributo 'id' de la burbuja:
			if(paciento.getBurbuja().equals(listaBurbujas.get(i).getid())) {
				// Se crea una nueva instancia del tipo de notificación con la burbuja y el paciente
				notificacion1 = new Notificacion_burbuja(listaBurbujas.get(i), paciento);
				// Se genera el mensaje
				notificacion1.setMensaje();
				// Se imprime el método 'toString' de la notificación.
				System.out.println("---------------------------------------------------------------------------");
				System.out.println("NOTIFICACION BURBUJA\n");
				System.out.println(notificacion1.toString());
				System.out.println("---------------------------------------------------------------------------\n");
			}
			
			
		}
		// Se recorre toda la lista de Establecimientos.
		for(int i = 0; i < listaEstablecimientos.size() ; i++) {
			// Si la persona está dentro de la lista de trabajadores del establecimiento:
			if(listaEstablecimientos.get(i).getTrabajadores().contains(paciento)) {
				// Se crea una nueva instancia del tipo de notificación con el establecimiento y el paciente
				notificacion2 = new Notificacion_recinto(listaEstablecimientos.get(i), paciento);
				// Se genera el mensaje
				notificacion2.setMensaje();
				// Se imprime el método 'toString' de la notificación.
				System.out.println("---------------------------------------------------------------------------\n");
				System.out.println("NOTIFICACION RECINTO\n");
				System.out.println(notificacion2.toString());
				System.out.println("---------------------------------------------------------------------------\n");
			}
			// Se declara el registro como el registro del establecimiento por el cuál se itera
			registro = listaEstablecimientos.get(i).getRegistro();
			// Si no hay personas en el registro:
			if(registro.size() == 0) {
				// Se continúa iterando
				continue;
			}
			// Se recorre el registro
			for(int k = 0; k < registro.size() ; k++) {
				// Si la persona está dentro del registro de clientes del establecimiento
				if(registro.get(k).getClientes().contains(paciento)) {
					// Se crea una nueva instancia del tipo de notificación con el establecimiento y el paciente
					notificacion3 = new Notificacion_contacto(registro.get(k),paciento);
					// Se genera el mensaje
					notificacion3.setMensaje();
					// Se imprime el método 'toString' de la notificación.
					System.out.println("---------------------------------------------------------------------------\n");
					System.out.println("NOTIFICACION CONTACTOS\n");
					System.out.println(notificacion3.toString());
					System.out.println("---------------------------------------------------------------------------\n");
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String mensaje;
		mensaje = establecimientos.get(2).toString();
		return mensaje;
	}
	
}
