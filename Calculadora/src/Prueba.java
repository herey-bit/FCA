public class Prueba{
	public static void main(String[] args) {
		ArregloCliente array = new ArregloCliente (3);
		Cliente cliente = new Cliente ("RFC","DANIEL","CDMX",123); 
		Cliente cliente3 = new Cliente ("RFC","DANIEL","CDMX",123); 
		Cliente cliente1 = new Cliente ("RFC","DANIELITO","CDMX",123); 
		System.out.println(array.agregar(cliente));
		System.out.println(array.agregar(cliente1));
		System.out.println(array.agregar(cliente3));

	}
}