import java.util.Scanner;

public class PruebaCalculadora {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        String cOperacion;
        Scanner entrada = new Scanner(System.in);
        calculadora.setResultado(entrada.nextFloat());

        do {
            entrada.nextLine();
            cOperacion = entrada.nextLine().toUpperCase();
            switch (Operaciones.valueOf(cOperacion)) {
                case SUMAR -> calculadora.suma(entrada.nextFloat());
                case RESTAR -> calculadora.resta(entrada.nextFloat());
                case MULTIPLICAR -> calculadora.multiplicacion(entrada.nextFloat());
                case DIVIDIR -> {
                    calculadora.setOperando(entrada.nextFloat());
                    if (calculadora.getOperando() == 0){
                        System.out.println("No puedes dividir entre cero");
                    } else {
                        calculadora.division(calculadora.getOperando());
                    }
                }
                case RESULTADO -> System.out.println(calculadora.getResultado());
            }
        } while (Operaciones.valueOf(cOperacion) != Operaciones.RESULTADO);
    }
}
