import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		Sistema sistema = parser.generarDatos();
		InstitucionAutorizada institucion = new InstitucionAutorizada("CCSS");
		menu(sistema, institucion);
		
		
	}

	public static void menu(Sistema sistema, InstitucionAutorizada institucion) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n========================== HelloThere ^^ ==========================\n");
		System.out.println("  Hola!\n  Saludos, qué gusto verte de nuevo! <(^o^)> \n ");
		while (true){
			mostrar_opciones();
			System.out.println("  Dime, ¿Qué te gustaría hacer?:");
			int opcion = scanner.nextInt();
			
			
			if(opcion == 1) {
				System.out.println("===================================================================\n\n");
				System.out.println("--------------Lista de Personas--------------\n");
				for(int i = 0;i<sistema.getPersonas().size();i++) {
					System.out.println(" " + (i + 1) + ". " + sistema.getPersonas().get(i).toString() + "\n");
				}
				System.out.println("===================================================================\n\n");
			}
			
			if(opcion == 2) {
				System.out.println("===================================================================\n\n");
				System.out.println("--------------Lista de Establecimientos--------------\n");
				for(int j = 0;j<sistema.getEstablecimientos().size();j++) {
					System.out.println("    " + (j + 1) + ". " + sistema.getEstablecimientos().get(j).getNombre() + "\n");
				}
				System.out.println("===================================================================\n\n");
			}
			
			if(opcion == 3) {
				System.out.println("===================================================================\n\n");
				System.out.println("--------------Lista de Burbujas--------------\n");
				for(int j = 0;j<sistema.getBurbujas().size();j++) {
					System.out.println(" " + (j + 1) + ". " + sistema.getBurbujas().get(j).toString() + "\n");
				}
				System.out.println("===================================================================\n\n");
			}
			
			if(opcion == 4) {
				
				System.out.println("  ¿Necesitas ver la lista de personas?");
				System.out.println("     0. No");
				System.out.println("     1. Sí");
				opcion = scanner.nextInt();
				
				if(opcion != 0) {
					System.out.println("--------------Lista de Personas--------------\n");
					for(int i = 0;i<sistema.getPersonas().size();i++) {
						System.out.println("     " + (i + 1) + ". " + sistema.getPersonas().get(i).getNombre() + "\n");
					}
					System.out.println("-------------------------------------------\n");
				}
				System.out.println("  Elija una persona: \n");
				int persona = scanner.nextInt()-1;
				if(persona>sistema.getPersonas().size()) {
					System.out.println("Esta persona no se encuentra en nuestro sistema, porfavor intentelo de nuevo");
					menu(sistema,institucion);
				}
				else {
					Persona personaEscogia = sistema.getPersonas().get(persona);
					personaEscogia.visitar_establecimiento(sistema.getEstablecimientos(), personaEscogia);
					System.out.println("\n");
				}

			}
			
			if(opcion == 5) {
				
				System.out.println("  ¿Necesitas ver la lista de personas?");
				System.out.println("     0. No");
				System.out.println("     1. Sí");
				opcion = scanner.nextInt();
				
				if(opcion != 0) {
					System.out.println("--------------Lista de Personas--------------\n");
					for(int i = 0;i<sistema.getPersonas().size();i++) {
						System.out.println("     " + (i + 1) + ". " + sistema.getPersonas().get(i).getNombre() + "\n");
					}
					System.out.println("-------------------------------------------\n");
				}
				System.out.println("  Elija una persona: \n");
				int persona = scanner.nextInt()-1;
				if(persona>sistema.getPersonas().size()) {
					System.out.println("Esta persona no se encuentra en nuestro sistema, porfavor intentelo de nuevo");
					menu(sistema,institucion);
				}
				
				else {
					Persona personaEscogia = sistema.getPersonas().get(persona);
					institucion.realizarPrueba(personaEscogia);
					
					if(personaEscogia.getCovi19() == true) {
						sistema.notificarContagio(sistema, personaEscogia);
					}
				}



			}
			
			if(opcion == 6) {
				System.out.println(institucion.toString());
			}
			
			if(opcion == 7) {
				System.out.println("=========================== SeeYou! ^^ ===========================\n");
				break;
			}
		}
		
		}
	
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
