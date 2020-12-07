public class ArregloCliente {

    public Cliente[] aClientes;
    private int posicion;

    public ArregloCliente(int longitud) {
        this.aClientes = new Cliente[longitud];
        this.posicion = -1;
    }

    public Cliente getCliente (String nombre){
        return aClientes[binarySearch(nombre)];
    }

    public Object validar(String oNombre) {
        int indice = binarySearch(oNombre);
        Object objeto = null;
        if (this.posicion == aClientes.length){ objeto = "\n\t Ya no puedes ingresar mas clientes.";}
        if (indice > -1){ objeto = aClientes[indice]; }
        return objeto;
    }
    public String agregar (Cliente oCliente){
       Object mensaje = validar(oCliente.getNombre());

        if (mensaje != null){

            if (mensaje.getClass() == oCliente.getClass()) {
                System.out.println("MENSAJE: Ya esta registrado");
                return "\n\t\"MENSAJE: El cliente ya esta registrado"; }
            else{
                System.out.println("Mensaje");
                return mensaje.toString();
            }

        } else{
            //System.out.println(oCliente.toString());
            insertionSort(oCliente);
            //System.out.println(this.posicion);
            return oCliente.toString();
        }
    }

    public String consultar (String nombre){
        Object mensaje = validar(nombre);

        if (mensaje != null){
            if (mensaje.getClass() == aClientes.getClass()){
                return mensaje.toString(); }
            else {
                return mensaje.toString();
            }
        } else {
            return "\n\t\"MENSAJE: No existe el cliente";
        }
    }


    public String listar (){
        String oClientes = "";
        int ePosicion;
        ePosicion = 0;
        if (this.posicion == -1){
            return "\n\t\"MENSAJE: No hay clientes registrados.";
        } else {
            while (ePosicion<aClientes.length){
                oClientes += aClientes[ePosicion].toString();
                ePosicion++;
            }
            return oClientes;
        }
    }

    public String eliminar(String nombre){
        Cliente oCliente;
        int contador = binarySearch(nombre);
            oCliente = aClientes[contador];
            aClientes[contador] = null;
            //this.posicion--;
            while (contador<posicion){
                aClientes[contador] = aClientes[contador+1];
                contador++;
            }
            this.posicion--;
            //aClientes[posicion+1] = null;

            return oCliente.toString();
    }

    public String actualizar(Cliente oCliente){

        aClientes[binarySearch(oCliente.getNombre())] = oCliente;
        return oCliente.toString();

    }


    public int binarySearch (String nombre){
        boolean flag;
        int inicio, mitad, ultimo, posicion;
        flag = false;
        posicion = -1;
        inicio = 0;
        ultimo = this.posicion;
        while ((inicio<=ultimo)&&(!flag)) {
            mitad = (inicio+ultimo)%2 == 0 ? ((inicio+ultimo)/2):((inicio+ultimo)/2)+1;
            if (aClientes[mitad].getNombre().toLowerCase().equals(nombre.toLowerCase())){
                posicion = mitad;
                flag = true;
            }

            if (nombre.toLowerCase().compareTo(aClientes[mitad].getNombre().toLowerCase()) < 0){
                ultimo = mitad - 1;

            } else {
                inicio =  mitad + 1;

            }

        }

        return posicion;
    }

    public void insertionSort (Cliente oCliente){
        String nombre;
        int ePosicion;
        ePosicion = this.posicion+1;
        nombre = oCliente.getNombre().toLowerCase();
        while ((ePosicion > 0) && (nombre.compareTo(aClientes[ePosicion-1].getNombre().toLowerCase())<0)){
            aClientes[ePosicion] = aClientes[ePosicion-1];
            ePosicion--;
        }
        this.posicion++;
        aClientes[ePosicion] = oCliente;

    }

}
