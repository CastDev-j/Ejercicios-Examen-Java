package Problema4.SolucionDos;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Necesita implementar una aplicación que requiere de números Aleatorios. En primera
 * instancia implemente una aplicación en java que le permita leer un número que indica
 * cuántos números debe generar y luego dos números adicionales, representando el límite
 * menor y el límite mayor entre los que se deben generar el conjunto de números. La cantidad
 * máxima que se pueden generar es de 5000 números.
 * Guarde sus números aleatorios generados y posteriormente implemente:
 * a) un método para determinar el número mayor
 * b) otro método para determinar el número menor de los datos generados.
 * c) Un método para imprimir los números en forma de renglón en bloques de 100 números.
 */
public class Main {

    public static void main(String[] args) {
        Datos datos = new Datos();
        datos.leerDatos();

        Aleatorios aleatorios = new Aleatorios(datos.cantidadNumeros, datos.limiteMenor, datos.limiteMayor);
        aleatorios.generarNumeros();
        aleatorios.imprimirNumeros();

        System.out.println("El número mayor es: " + aleatorios.numeroMayor());
        System.out.println("El número menor es: " + aleatorios.numeroMenor());
    }
}

class Datos {
    int cantidadNumeros;
    int limiteMenor;
    int limiteMayor;
    private Scanner scanner;

    public Datos() {
        scanner = new Scanner(System.in);
    }

    public void leerDatos() {
        System.out.println("Ingrese la cantidad de números a generar (máximo 5000): ");
        cantidadNumeros = leerInt(1, 5000);

        System.out.println("Ingrese el límite menor: ");
        limiteMenor = leerInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println("Ingrese el límite mayor: ");
        limiteMayor = leerInt(limiteMenor, Integer.MAX_VALUE);
    }

    private int leerInt(int min, int max) {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num < min || num > max) {
                    System.out.println("Por favor, ingrese un número entre " + min + " y " + max + ": ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero: ");
            }
        }
        return num;
    }
}

class Aleatorios {
    private int cantidadNumeros;
    private int limiteMenor;
    private int limiteMayor;
    private int[] numeros;

    public Aleatorios(int cantidadNumeros, int limiteMenor, int limiteMayor) {
        this.cantidadNumeros = cantidadNumeros;
        this.limiteMenor = limiteMenor;
        this.limiteMayor = limiteMayor;
    }

    public void generarNumeros() {
        numeros = new int[cantidadNumeros];
        for (int i = 0; i < cantidadNumeros; i++) {
            numeros[i] = (int) (Math.random() * (limiteMayor - limiteMenor + 1) + limiteMenor);
        }
    }

    public void imprimirNumeros() {
        for (int i = 0; i < cantidadNumeros; i += 100) {
            int end = Math.min(i + 100, cantidadNumeros);
            int[] bloque = Arrays.copyOfRange(numeros, i, end);
            System.out.println(Arrays.toString(bloque));
        }
    }

    public int numeroMayor() {
        int mayor = Integer.MIN_VALUE;
        for (int i = 0; i < cantidadNumeros; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
        return mayor;
    }

    public int numeroMenor() {
        int menor = Integer.MAX_VALUE;
        for (int i = 0; i < cantidadNumeros; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }
        return menor;
    }
}
