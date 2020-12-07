import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {

    private int id = inicId();
    private static String fechaRegistro = inicFechaRegistro();
    private String rfc;
    private String nombre;
    private String domicilio;
    private long telefono;

    public Cliente(String rfc, String nombre, String domicilio, long telefono) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public Cliente (Cliente nuevoCliente){
        this.id = nuevoCliente.id;
        this.nombre = nuevoCliente.nombre;
        this.domicilio = nuevoCliente.domicilio;
        this.telefono =  nuevoCliente.telefono;
        this.rfc = nuevoCliente.rfc;
    }

    private static String inicFechaRegistro(){
        Date fecha = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return formatoFecha.format(fecha).toUpperCase();
    }

    protected int inicId (){


        return (int)Math.round(Math.random()*1000+900);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getFechaRegistro() {
        return fechaRegistro;
    }

    public static void setFechaRegistro(String fechaRegistro) {
        Cliente.fechaRegistro = fechaRegistro;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String toString(){
        return "\n" + this.id + " " + this.rfc + " " + this.nombre + " " +
                 " " + this.domicilio + " " + this.telefono +" "+ fechaRegistro.toString() +"\n";
    }
}
