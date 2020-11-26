import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
// Se declara la clase Persona
public class Persona {
	// Atributos
	private String nombre;
	private String id;
	private String teléfono;
	private String fechaDeNacimiento;
	private String tipo;
	private String correo;
	private String idBurbuja;
	private String género;
	private boolean covid19;
	// Método constructor
	public Persona(String nombre, String id, String teléfono, String fechaDeNacimiento, String tipo, String correo,
			String idBurbuja, String género) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.teléfono = teléfono;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.tipo = tipo;
		this.correo = correo;
		this.idBurbuja = idBurbuja;
		this.género = género;
		// Toda persona apenas se crea no tiene covid
		this.covid19 = false;
	}
	// Método para delcarar el atributo 'covid19' como true
	public void setCovid19() {
		this.covid19 = true;
	}
	// Método para retornar el atributo 'nombre'
	public String getNombre() {
		return nombre;
	}
	// Método para retornar el atributo 'teléfono'
	public String getTelefono() {
		return teléfono;
	}
	// Método para retornar el atributo 'tipo'
	public String getTipo() {
		return tipo;
	}
	// Método para retornar el atributo 'idBurbuja'
	public String getBurbuja() {
		return idBurbuja;
	}
	// Método para retornar el atributo 'covid19'
	public boolean getCovi19() {
		return covid19;
	}
	
	// Actualiza el registro de un establecimiento con el dia actual y la persona que visito dicho lugar
	public void visitar_establecimiento(ArrayList<Establecimiento> establecimientos, Persona persona) {
		// Declaración de variables
		Dia dia;
		// scanner registra la entrada del usuario
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n");
		// Recorre la lista de establecimientos
		for(int i = 0; i < establecimientos.size();i++) {
			// Se imprime la lista con índices y el nombre del establecimiento
			System.out.println(i + 1 + " " + establecimientos.get(i).getNombre() + "\n");
		}
		// Mensaje al usuario
		System.out.println("Ingrese el establecimiento \n");
		// Se registra la opcion del usuario
		int indice = scanner.nextInt() -1;
		
		// Se obtiene el establecimiento a partir de la opción
		Establecimiento establecimiento = establecimientos.get(indice);
		// Se obtiene el registro a partir del establecimiento
		ArrayList<Dia> registro = establecimiento.getRegistro();
		
		// Si el registro está vacío:
		if(registro.size() == 0) {
			// Se crea una instancia de día
			dia = new Dia();
			// Se actualiza el registro del día
			establecimiento.actualizarRegistro(dia);
			// Se añade al registro la persona
			registro.get(0).añadirCliente(persona);
			
		}
		// Si la lista NO está vacía
		else {
			// Se declara la fecha
			LocalDate fecha = LocalDate.now();
			// Se recorre el registro
			for(int i = 0; i < registro.size();i++) {
				// Si las fechas coinciden:
				if(registro.get(i).getFecha().compareTo(fecha) == 0) {
					// Se añade a la lista de clientes la persona y se quiebra el ciclo
					registro.get(i).añadirCliente(persona);
					break;
					}
				}
			}
		// Se imprime el registro.
		establecimiento.imprimirRegistro();
		
		}
	// Se sobre escribe el método 'toString' de la clase
	@Override
	public String toString() {
		String mensaje = "Nombre: " + this.nombre + "\n" + 
						 "   -ID: " + this.id + "\n" +
						 "   -Tipo: " + this.tipo + "\n" + 
						 "   -Burbuja: " + this.idBurbuja + "\n" +
						 "   -Fecha de Nacimiento: " + this.fechaDeNacimiento + "\n" +
  						 "   -Correo: " + this.correo + "\n" + 
						 "   -Teléfono: " + this.teléfono + "\n" +
						 "   -Estado Covid19: " + this.covid19 + "\n";
							
		return mensaje;
	}	
}