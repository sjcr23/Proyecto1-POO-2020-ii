import java.util.Scanner;

// Declaración de la clase Main
public class main {
	// Método principal
	public static void main(String[] args) {
		// Declaración del Parser: encargado de hacer los objetos de los .json
		JSONParser parser = new JSONParser();
		// Se rellenan los listas correspondinetes a los atributos del sistema
		Sistema sistema = parser.generarDatos();
		// Se crea una institución
		InstitucionAutorizada institucion = new InstitucionAutorizada("CCSS");
		menu(sistema, institucion);
	}

	public static void menu(Sistema sistema, InstitucionAutorizada institucion) {
		// Se crea un scanner
		Scanner scanner = new Scanner(System.in);
		// Se imprime un mensaje de bienvenida
		System.out.println("\n========================== HelloThere ^^ ==========================\n");
		System.out.println("  Hola!\n  Saludos, qué gusto verte de nuevo! <(^o^)> \n ");
		// Se empieza el ciclo del menú
		while (true){
			// Se imprime en pantalla las opciones para el usuario
			mostrar_opciones();
			// Se imprime en pantalla un mensaje para el usuario
			System.out.println("  Dime, ¿Qué te gustaría hacer?:");
			// Se registra la opción del usuario
			int opcion = scanner.nextInt();
			
			// Si el usuario elige ver la lista de personas:
			if(opcion == 1) {
				// Imprimimos lo siguiente para que se vea bien en la terminal.
				System.out.println("===================================================================\n\n");
				System.out.println("--------------Lista de Personas--------------\n");
				// Recorremos la lista de personas del sistema
				for(int i = 0;i<sistema.getPersonas().size();i++) {
					// Se imprime la lista con índices y el método 'toString' pertenenciente a la persona
					System.out.println(" " + (i + 1) + ". " + sistema.getPersonas().get(i).toString() + "\n");
				}
				System.out.println("===================================================================\n\n");
			}
			
			// Si el usuario elige ver la lista de establecimientos:
			if(opcion == 2) {
				// Imprimimos lo siguiente para que se vea bien en la terminal.
				System.out.println("===================================================================\n\n");
				System.out.println("--------------Lista de Establecimientos--------------\n");
				// Recorremos la lista de establecimientos del sistema
				for(int j = 0;j<sistema.getEstablecimientos().size();j++) {
					// Imprimos la lista con índices y el nombre perteneciente al establecimiento
					System.out.println("    " + (j + 1) + ". " + sistema.getEstablecimientos().get(j).getNombre() + "\n");
				}
				System.out.println("===================================================================\n\n");
			}
			
			// Si el usuario elige ver la lista de burbujas:
			if(opcion == 3) {
				// Imprimimos lo siguiente para que se vea bien en la terminal.
				System.out.println("===================================================================\n\n");
				System.out.println("--------------Lista de Burbujas--------------\n");
				// Recorremos la lista de burbujas del sistema
				for(int j = 0;j<sistema.getBurbujas().size();j++) {
					// Imprimos la lista con índices y el método 'toString' pertenenciente a la burbuja
					System.out.println(" " + (j + 1) + ". " + sistema.getBurbujas().get(j).toString() + "\n");
				}
				System.out.println("===================================================================\n\n");
			}
			// Si el usuario elige hacer que una persona visite un establecimiento
			if(opcion == 4) {
				// Se pregunta al usuario si necesita ver la lista de personas
				System.out.println("  ¿Necesitas ver la lista de personas?");
				System.out.println("     0. No");
				System.out.println("     1. Sí");
				// Se registra su respuesta
				opcion = scanner.nextInt();
				
				// Si el usuario necesecita ver la lista:
				if(opcion != 0) {
					// Imprimimos lo siguiente para que se vea bien en la terminal.
					System.out.println("--------------Lista de Personas--------------\n");
					// Recorremos la lista de personas del sistema
					for(int i = 0;i<sistema.getPersonas().size();i++) {
						// Imprimos la lista con índices y el método 'toString' pertenenciente a la persona
						System.out.println("     " + (i + 1) + ". " + sistema.getPersonas().get(i).getNombre() + "\n");
					}
					System.out.println("-------------------------------------------\n");
				}
				// Se pregunta al usuario la persona que va a escoger
				System.out.println("  Elija una persona: \n");
				// Se registra su respuesta
				int persona = scanner.nextInt()-1;
				// Si la persona no está en la lista:
				if(persona>sistema.getPersonas().size()) {
					// Se imprime el mensaje de error
					System.out.println("Esta persona no se encuentra en nuestro sistema, porfavor intentelo de nuevo");
					// Se vuelve a emepezar el menú
					menu(sistema,institucion);
				}
				else {
					// Creamos una instancia nueva de persona correspondiendo a la persona escogida
					Persona personaEscogia = sistema.getPersonas().get(persona);
					// Se invoca a la función correspondiente a la elección del usuario
					personaEscogia.visitar_establecimiento(sistema.getEstablecimientos(), personaEscogia);
					System.out.println("\n");
				}

			}
			
			// Si el usuario elige hacer que una persona se haga la prueba covid
			if(opcion == 5) {
				// Se pregunta al usuario si necesita ver la lista de personas
				System.out.println("  ¿Necesitas ver la lista de personas?");
				System.out.println("     0. No");
				System.out.println("     1. Sí");
				// Se registra su respuesta
				opcion = scanner.nextInt();
				
				// Si el usuario necesecita ver la lista:
				if(opcion != 0) {
					// Imprimimos lo siguiente para que se vea bien en la terminal.
					System.out.println("--------------Lista de Personas--------------\n");
					// Recorremos la lista de personas del sistema
					for(int i = 0;i<sistema.getPersonas().size();i++) {
						// Imprimos la lista con índices y el método 'toString' pertenenciente a la persona
						System.out.println("     " + (i + 1) + ". " + sistema.getPersonas().get(i).getNombre() + "\n");
					}
					System.out.println("-------------------------------------------\n");
				}
				// Se pregunta al usuario la persona que va a escoger
				System.out.println("  Elija una persona: \n");
				// Se registra su respuesta
				int persona = scanner.nextInt()-1;
				// Si la persona no está en la lista:
				if(persona>sistema.getPersonas().size()) {
					// Se imprime el mensaje de error
					System.out.println("Esta persona no se encuentra en nuestro sistema, porfavor intentelo de nuevo");
					// Se vuelve a emepezar el menú
					menu(sistema,institucion);
				}
				else {
					// Creamos una instancia nueva de persona correspondiendo a la persona escogida
					Persona personaEscogia = sistema.getPersonas().get(persona);
					// Se invoca a la función correspondiente a la elección del usuario
					institucion.realizarPrueba(personaEscogia);
					
					// Si se registra un contagio:
					if(personaEscogia.getCovi19() == true) {
						// Se notifica el contagio por: burbuja, recinto, contacto (según corresponda)
						sistema.notificarContagio(sistema, personaEscogia);
					}
				}

			}
			// Si el usuario elige generar el reporte de pruebas covid19
			if(opcion == 6) {
				// Se imprime el método 'toString' de la institución
				System.out.println(institucion.toString());
			}
			// Si el usuario elige salir del menú
			if(opcion == 7) {
				// Se imprime una despedida y se cierra el ciclo
				System.out.println("=========================== SeeYou! ^^ ===========================\n");
				break;
			}
		}
		
		}
	
	// Se imprimen todas las opciones que el menú puede realizar.
	public static void mostrar_opciones() {
		System.out.println("     1. Mostrar Lista de personas.");
		System.out.println("     2. Mostrar Lista de establecimientos.");
		System.out.println("     3. Mostrar Lista de Burbujas.");
		System.out.println("     4. Hacer que una persona visite un establicimiento.");
		System.out.println("     5. Hacer que una persona se realize la prueba de covid.");
		System.out.println("     6. Generar reporte de pruebas. ");
		System.out.println("     7. Salir del menú.\n");
	}
}
