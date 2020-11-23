
public class main {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		Sistema sistema = parser.generarDatos();
		sistema = parser.generarClientes(sistema);
		
		System.out.println(sistema.toString());
		

	}

}
