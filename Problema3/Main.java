package Problema3;

/*
Una forma de calcular la raíz cuadrada de un número es usar aproximaciones sucesivas y hacerlo a través de varias iteraciones. Digamos que le dan un número, a, y quiere encontrar su raíz cuadrada. Una forma de hacerlo es comenzar con una estimación aproximada de la respuesta, x0, y luego mejorarla utilizando esta fórmula:

x1 =(x0 + a/x0) / 2

Por ejemplo, si queremos encontrar la raíz cuadrada de 9 y comenzamos con x0 = 6, entonces x1 = (6 + 9/6) / 2 = 3,75, que está más cerca. Podemos repetir el procedimiento, usando x1 para calcular x2, y así sucesivamente. En este caso, x2 = 3,075 y x3 = 3,00091. Por lo que converge rápidamente hacia la respuesta correcta.

Escriba un método llamado squareRoot que tome un número (double) y devuelva una aproximación de la raíz cuadrada del parámetro, utilizando esta técnica. Obtenga la raíz con un margen de error de 0.00001. No está permitido usar Math.sqrt.

Este método tendrá dos variantes (dos versiones del método):

a) Primero utilizando el ciclo while
b) La variante dos, consiste en utilizar ya sea un ciclo for o cualquier otro ciclo diferente a while.
*/

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.squareRoot(9));
        System.out.println(s.squareRoot(16));

        Solution2 s2 = new Solution2();
        System.out.println(s2.squareRoot(9));
        System.out.println(s2.squareRoot(16));
    }
}

class Solution {
    public double squareRoot(double a) {
        double x0 = a;
        double x1 = (x0 + a / x0) / 2;
        while (Math.abs(x1 - x0) > 0.00001) {
            x0 = x1;
            x1 = (x0 + a / x0) / 2;
        }
        return x1;
    }
}

class Solution2 {
    public double squareRoot(double a) {
        double x0 = a;
        double x1 = (x0 + a / x0) / 2;
        for (int i = 0; Math.abs(x1 - x0) > 0.00001; i++) {
            x0 = x1;
            x1 = (x0 + a / x0) / 2;
        }
        return x1;
    }
}
