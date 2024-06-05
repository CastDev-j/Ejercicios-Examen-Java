package Problema1;

/*
En una disertación con especialistas se ha decidido que la estructura inicial de la
aplicación puede ser una clase Alumno relacionada con una clase Materia y por cada
materia se tendrá una clase Nota donde puede agregar la calificación numérica y también
un mecanismo para determinar el grado de aprovechamiento del alumno en esa materia.
a) Determine y muestre en un diagrama los atributos y métodos de la clase Alumno.
b) Determine y muestre en un diagrama los atributos de la clase Materia (considere) al
menos 4 materias.
c) Determine y muestre en un diagrama los atributos y métodos de la clase Nota o
calificación.
d) Establezca la relación entre las clases anteriores
*/

public class Main {
    public static void main(String[] args) {
        // Crear objetos Alumno, Materia y Nota
        Alumno alumno = new Alumno("Juan", 20, "Calle Falsa 123");
        Materia materia1 = new Materia("Matemáticas", 4);
        Materia materia2 = new Materia("Programación", 5);
        Materia materia3 = new Materia("Base de Datos", 3);
        Materia materia4 = new Materia("Redes", 3);
        
        Nota nota1 = new Nota(90);
        Nota nota2 = new Nota(85);
        Nota nota3 = new Nota(88);
        Nota nota4 = new Nota(92);
        
        alumno.agregarMateria(materia1, nota1);
        alumno.agregarMateria(materia2, nota2);
        alumno.agregarMateria(materia3, nota3);
        alumno.agregarMateria(materia4, nota4);
        
        alumno.mostrarInformacion();
    }
}

class Alumno {
    // Atributos
    private String nombre;
    private int edad;
    private String direccion;
    private Materia[] materias;
    private Nota[] notas;
    private int contadorMaterias;
    
    // Constructor
    public Alumno(String nombre, int edad, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.materias = new Materia[4];
        this.notas = new Nota[4];
        this.contadorMaterias = 0;
    }
    
    // Métodos
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void agregarMateria(Materia materia, Nota nota) {
        if (contadorMaterias < 4) {
            materias[contadorMaterias] = materia;
            notas[contadorMaterias] = nota;
            contadorMaterias++;
        } else {
            System.out.println("No se pueden agregar más de 4 materias.");
        }
    }
    
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Direccion: " + direccion);
        for (int i = 0; i < contadorMaterias; i++) {
            System.out.println("Materia: " + materias[i].getNombre());
            System.out.println("Créditos: " + materias[i].getCreditos());
            System.out.println("Nota: " + notas[i].getCalificacion());
            System.out.println("Aprovechamiento: " + notas[i].interpretarNota());
        }
    }
}

class Materia {
    // Atributos
    private String nombre;
    private int creditos;
    
    // Constructor
    public Materia(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }
    
    // Métodos
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCreditos() {
        return creditos;
    }
    
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
}

class Nota {
    // Atributos
    private double calificacion;
    
    // Constructor
    public Nota(double calificacion) {
        this.calificacion = calificacion;
    }
    
    // Métodos
    public double getCalificacion() {
        return calificacion;
    }
    
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    
    public String interpretarNota() {
        if (calificacion >= 90) {
            return "Excelente";
        } else if (calificacion >= 80) {
            return "Bueno";
        } else if (calificacion >= 70) {
            return "Regular";
        } else {
            return "Malo";
        }
    }
}
