package Problema2;

import java.util.Scanner;

/*
Una institución Educativa le encarga la implementación de una aplicación para llevar el registro de las notas (calificaciones) de sus alumnos. Su primera acción fue el diseño de la estructura o diseño de clases en base a los requerimientos obtenidas, su segunda acción será la implementación en Java del diseño, en base a las consideraciones del reactivo 1: 
 
a) Implemente la clase Alumno, con sus atributos y parámetros. 
b) Implemente un mecanismo que le permita capturar los datos de un alumno. 
c) Implemente el mecanismo para capturar los datos de al menos cuatro materias del alumno. (nombre materia, créditos y horas a la semana). 
d) Implemente la clase Nota para registrar una calificación por cada materia. 
e) Construya una clase donde integre las clases Alumno y Materias. 
f) Construya el método que determine la interpretación de la calificación del alumno para un rango determinado. El instructor le dará los límites del rango. 
 
La aplicación en este caso estaría en posibilidades de capturar los datos de un alumno, capturar y guardar al menos cuatro notas del alumno y obtener un promedio en base a sus calificaciones e interpretar el promedio o nota obtenido. 
*/

public class Main {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        alumno.capturarDatos();
        alumno.capturarMaterias();
        alumno.capturarNotas();
        alumno.mostrarDatos();
        alumno.mostrarMaterias();
        alumno.mostrarNotas();
        alumno.mostrarPromedio();
        alumno.interpretarNota();
    }
}

class Alumno {
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private Materia[] materias = new Materia[4];
    private Nota[] notas = new Nota[4];
    private double promedio;

    private Scanner scanner = new Scanner(System.in);

    public void capturarDatos() {
        System.out.println("Ingrese el nombre del alumno: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del alumno: ");
        apellido = scanner.nextLine();
        System.out.println("Ingrese la edad del alumno: ");
        edad = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Ingrese la carrera del alumno: ");
        carrera = scanner.nextLine();
    }

    public void capturarMaterias() {
        for (int i = 0; i < 4; i++) {
            materias[i] = new Materia();
            System.out.println("Ingrese el nombre de la materia " + (i + 1) + ": ");
            materias[i].nombre = scanner.nextLine();
            System.out.println("Ingrese los créditos de la materia " + (i + 1) + ": ");
            materias[i].creditos = scanner.nextInt();
            System.out.println("Ingrese las horas a la semana de la materia " + (i + 1) + ": ");
            materias[i].horas = scanner.nextInt();
            scanner.nextLine(); 
        }
    }

    public void capturarNotas() {
        for (int i = 0; i < 4; i++) {
            notas[i] = new Nota();
            System.out.println("Ingrese la nota para la materia " + materias[i].nombre + ": ");
            notas[i].calificacion = scanner.nextInt();
        }
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Carrera: " + carrera);
    }

    public void mostrarMaterias() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Materia: " + materias[i].nombre);
            System.out.println("Creditos: " + materias[i].creditos);
            System.out.println("Horas: " + materias[i].horas);
        }
    }

    public void mostrarNotas() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Materia: " + materias[i].nombre);
            System.out.println("Nota: " + notas[i].calificacion);
        }
    }

    public void mostrarPromedio() {
        int suma = 0;
        for (int i = 0; i < 4; i++) {
            suma += notas[i].calificacion;
        }
        promedio = suma / 4.0;
        System.out.println("Promedio: " + promedio);
    }

    public void interpretarNota() {
        if (promedio >= 90) {
            System.out.println("Excelente");
        } else if (promedio >= 80) {
            System.out.println("Bueno");
        } else if (promedio >= 70) {
            System.out.println("Regular");
        } else {
            System.out.println("Malo");
        }
    }
}

class Materia {
    String nombre;
    int creditos;
    int horas;
}

class Nota {
    int calificacion;
}
