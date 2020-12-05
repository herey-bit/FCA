public class Calculadora {

    private float operando;
    private float resultado;

    public float getOperando() {
        return operando;
    }

    public void setOperando(float operando) {
        this.operando = operando;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public Calculadora (){
        this.resultado = 0;
        this.operando = 0;
    }

    public void suma(float flotante){
        resultado = resultado + flotante;
    }
    public void resta(float flotante){
        resultado = resultado - flotante;
    }
    public void multiplicacion(float flotante){
        resultado = resultado * flotante;
    }
    public void division(float flotante){
        resultado = resultado / flotante;
    }

}
