import java.util.Scanner;

public class AplicacionCliente {

    private static final Scanner entrada = new Scanner(System.in);
    public ArregloCliente aClientes;

    public AplicacionCliente(int posicion) {
        this.aClientes = new ArregloCliente(posicion);
    }

    public void menu() {

        String nombre;
        int opcion, ePosicion;


        do {
            System.out.print("\n\tCRUD DE CLIENTES\n" +
                    "(1) Registrar Cliente (2) Consultar Cliente\n" +
                    "(3) Listar Clientes (4) Actualizar Cliente\n" +
                    "(5) Borrar Cliente (6) Salir\n" +
                    "Opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {

                case 1 -> printFormato(aClientes.agregar(leerCliente()));
                case 3 -> printFormato(aClientes.listar());
                case 2 -> printFormato(aClientes.consultar(leerNombre()));
                case 4 -> { nombre = aClientes.consultar(leerNombre());
                    if (nombre.contains("MENSAJE")){
                        printFormato(nombre);
                    } else {
                        Cliente oCliente = enviar(nombre);
                        if (oCliente == null){
                            printFormato("\n\tMENSAJE: No se ha realizado ninguna operacion.");
                        } else {
                            System.out.println(aClientes.actualizar(oCliente));
                        }
                        printFormato(aClientes.eliminar(nombre));
                    }
                }
                case 5 -> { nombre = aClientes.consultar(leerNombre());
                    if (nombre.contains("MENSAJE")){
                        printFormato(nombre);
                    } else {
                        printFormato(aClientes.eliminar(nombre));
                    }
                }
                case 6 -> System.out.println("Adios");
                default -> System.out.println("Selecciona una opcion valida");
            }
        } while (opcion != 6);
    }

    public static int numeroClientes() {
        int opcion;
        do {
            System.out.println("Ingresa el numero de clientes para administrar: ");
            opcion = entrada.nextInt();
        } while (opcion < 1);

        return opcion;
    }

    public String leerRFC() {
        System.out.println("Ingresa el RFC del Cliente: \t");
        return entrada.nextLine();
    }

    public String leerNombre() {
        System.out.println("Ingresa el nombre del Cliente: \t");
        return entrada.nextLine();
    }

    public String leerDomicilio() {
        System.out.println("Ingresa el domicilio del cliente: \t");
        return entrada.nextLine();
    }

    public long leerTelefono() {
        System.out.println("Ingresa numero de telefono: \t");
        return entrada.nextLong();
    }

    public Cliente leerCliente() {

        String rfc, nombre, domicilio;
        long telefono;

        rfc = leerRFC();
        nombre = leerNombre();
        domicilio = leerDomicilio();
        telefono = leerTelefono();

        return new Cliente(rfc, nombre, domicilio, telefono);
    }

    public Cliente enviar(String mensaje) {

        Cliente oCliente = new Cliente(aClientes.getCliente(mensaje));
        int opcion, posicion;

        if ( oCliente != null) {

            do {
                System.out.print("\n\tSelecciona el campo que deseas modificar\n\t" +
                        "(1)RFC " + "(2)Domicilio " + "(3)Telefono " +
                        " (4) Salir \n" + "\t Opcion: \t");
                opcion = entrada.nextInt();
                entrada.nextLine();
                switch (opcion) {
                    case 1 -> oCliente.setRfc(leerRFC());
                    case 2 -> oCliente.setDomicilio(leerDomicilio());
                    case 3 -> oCliente.setTelefono(leerTelefono());
                    case 4 -> System.out.println("adios.".toUpperCase());
                    default -> System.out.println("Elige una opcion correcta.".toUpperCase());
                }
            } while (opcion != 4);

            if (confirmar()==true){
                return oCliente;
            } else {

                return null;
            }

        } else {
            return null;
        }
    }

    public void printFormato (String cadena){
        int eContador;
        eContador = 0;
        if (cadena.contains("MENSAJE")){
            System.out.println(cadena.toUpperCase());
        }else{
            System.out.printf("\n%s%15s%15s%15s%15s%15s\n\n","ID","RFC","NOMBRE","DOMICILIO","TELEFONO","FECHA REGISTRO\n");
            for (String renglon: cadena.split(" ")) {
                eContador++;
                System.out.printf("%15s",renglon);
                if (eContador%6 == 0){
                    System.out.println();
                }

            }
        }
    }

    public boolean confirmar(){
        int flag;
        do {
            System.out.println("\n ¿Seguro que quiere realizar la operacion?" +
                    "\n(0) Si (1) No");
            flag = entrada.nextInt();
        } while (flag != 0 && flag != 1);

        if(flag == 0)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        AplicacionCliente appCliente = new AplicacionCliente(numeroClientes());
        appCliente.menu();
    }
}
