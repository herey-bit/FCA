public class Prueba{
	public static void main(String[] args) {
		ArregloCliente array = new ArregloCliente (4);
		Cliente cliente1 = new Cliente ("RFC","DANIELITO","CDMX",123); 
		Cliente cliente2 = new Cliente ("RFC","JUAN","CDMX",123); 
		Cliente cliente3 = new Cliente ("RFC","QWERTY","CDMX",123); 
		Cliente cliente4 = new Cliente ("RFC","ASDFG","CD822MX",123); 
		Cliente cliente5 = new Cliente ("RFC","QWERTY","CDgergegMX",123); 
		
		Cliente daniel;

		daniel = new Cliente(cliente3);

		cliente3.setRfc("HELLO");
		daniel.setNombre("HECTOR");

		System.out.println(cliente3.toString());
		System.out.println(daniel.toString());
		System.out.println(Cliente.getFechaRegistro());

		/*
		System.out.println("**************************************hhhhh");
		 */
		/*
		System.out.println(array.consultar("qwer"));

		System.out.println(array.agregar(cliente1));
		System.out.println("**************************************");
		System.out.println(array.agregar(cliente2));
		System.out.println("**************************************");
		System.out.println(array.agregar(cliente3));
		System.out.println("**************************************");
		System.out.println(array.agregar(cliente4));
		System.out.println("**************************************");
		System.out.println(array.agregar(cliente5));
		System.out.println("**************************************");
		System.out.println(array.agregar(cliente1));

		for (Cliente a: array.aClientes
			 ) {
			System.out.println(a.toString());
		}

		System.out.println("**************************************hhhhh");
		System.out.println(array.consultar("QWERTY"));
		System.out.println("**************************************hhhhh");
		System.out.println(array.consultar("danielito"));
		System.out.println("**************************************hhhhh");
		System.out.println(array.consultar("asdfg"));
		System.out.println("**************************************hhhhh");
		System.out.println(array.consultar("qwer"));

		System.out.println("**************************************hhhhh");
		System.out.println(array.listar());
		System.out.println("**************************************hhhhh");
		System.out.println(array.eliminar("asdfg"));
		Cliente cliente14 = new Cliente ("RFC","raul","CD822MX",123); 
		array.agregar(cliente14);
		System.out.println("**************************************hhhhh");
		System.out.println(array.listar());
		System.out.println(array.eliminar("juan"));
		Cliente cliente141 = new Cliente ("RFC","kiko","CD822MX",123); 
		array.agregar(cliente141);
		System.out.println("**************************************hhhhh");
		System.out.println(array.listar());
		*/
	}
}