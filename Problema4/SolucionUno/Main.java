package Problema4.SolucionUno;

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
        Aleatorios aleatorios = new Aleatorios();
        aleatorios.leerDatos();
        aleatorios.generarNumeros();
        aleatorios.imprimirNumeros();
        System.out.println("El número mayor es: " + aleatorios.numeroMayor());
        System.out.println("El número menor es: " + aleatorios.numeroMenor());
    }
    
}

class Aleatorios {
    private int cantidadNumeros;
    private int limiteMenor;
    private int limiteMayor;
    private int[] numeros;
    private Leer leer = new Leer(); 

    public void leerDatos() {
        System.out.println("Ingrese la cantidad de números a generar (máximo 5000): ");
        cantidadNumeros = leer.datoInt();
        while (cantidadNumeros < 1 || cantidadNumeros > 5000) {
            System.out.println("Por favor, ingrese un número entre 1 y 5000: ");
            cantidadNumeros = leer.datoInt();
        }
        
        System.out.println("Ingrese el límite menor: ");
        limiteMenor = leer.datoInt();
        
        System.out.println("Ingrese el límite mayor: ");
        limiteMayor = leer.datoInt();
        
        while (limiteMayor < limiteMenor) {
            System.out.println("El límite mayor debe ser mayor o igual al límite menor. Intente nuevamente: ");
            limiteMayor = leer.datoInt();
        }
    }
    
    public void generarNumeros() {
        numeros = new int[cantidadNumeros];
        for (int i = 0; i < cantidadNumeros; i++) {
            numeros[i] = (int) (Math.random() * (limiteMayor - limiteMenor + 1) + limiteMenor);
        }
    }
    
    public void imprimirNumeros() {
        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.print(numeros[i] + " ");
            if ((i + 1) % 100 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    public int numeroMayor() {
        int mayor = numeros[0];
        for (int i = 1; i < cantidadNumeros; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
        return mayor;
    }
    
    public int numeroMenor() {
        int menor = numeros[0];
        for (int i = 1; i < cantidadNumeros; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }
        return menor;
    }
}

class Leer {

    private Scanner scanner;

    public Leer() {
        scanner = new Scanner(System.in);
    }

    public int datoInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero: ");
            }
        }
    }
}
