/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Real Madrid
 */
public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
    do {
        
        System.out.println("1. Agregar libro");
        System.out.println("2. Buscar libro por titulo");
        System.out.println("3. Buscar libro por autor");
        System.out.println("4. Prestar libro");
        System.out.println("5. Devolver libro");
        System.out.println("6. Mostrar libro disponibles");
        System.out.println("0. Salir");
        opcion = scanner.nextInt();
        scanner.nextLine();
        
    switch(opcion){
        case 1:
            System.out.print("Titulo: ");
            String titulo = scanner.nextLine();
            System.out.print("Autor: ");
            String autor = scanner.nextLine();
            System.out.print("Año de publicacion: ");
            int ano = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Genero: ");
            String genero = scanner.nextLine();
            biblioteca.agregarLibro(new Libro(titulo, autor, ano, genero));
            break;
        case 2:
           System.out.print("Titulo a buscar: ");
           biblioteca.buscarPorTitulo(scanner.nextLine());
           break;
         case 3:
           System.out.print("Autor a buscar: ");
           biblioteca.buscarPorAutor(scanner.nextLine());
           break;   
         case 4:
           System.out.print("Titulo del libro a prestar: ");
           biblioteca.prestarLibro(scanner.nextLine());
           break;   
         case 5:
           System.out.print("Titulo del libro a devolver ");
           biblioteca.devolverLibro(scanner.nextLine());
           break; 
         case 6:
           biblioteca.mostrarLibrosDisponibles();
           break;  
         case 0:
           System.out.print("Saliendo.... ");
           biblioteca.buscarPorTitulo(scanner.nextLine());
           break;
           default:   
           System.out.println("Opcion no valida. ");
    } 
    } while (opcion !=0);         
    
    scanner.close();
    }
}
 

class Biblioteca {
    private ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    public void buscarPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.mostrarInfo();
            }
        }
    }

    public void buscarPorAutor(String autor) {
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                libro.mostrarInfo();
            }
        }
    }

    public void prestarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.isDisponible()) {
                libro.prestar();
                System.out.println("Libro prestado: " + titulo);
                return;
            }
        }
        System.out.println("El libro no está disponible o no existe.");
    }

    public void devolverLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.isDisponible()) {
                libro.devolver();
                System.out.println("Libro devuelto: " + titulo);
                return;
            }
        }
        System.out.println("El libro no está prestado o no existe.");
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles:");
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                libro.mostrarInfo();
            }
        }
    }
}

class Libro {
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private String genero;
    private boolean disponible;

    public Libro(String titulo, String autor, int anoPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.genero = genero;
        this.disponible = true; 
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        this.disponible = false;
    }

    public void devolver() {
        this.disponible = true;
    }

    public void mostrarInfo() {
        System.out.printf("Título: %s, Autor: %s, Año: %d, Género: %s, Disponible: %s%n",
                titulo, autor, anoPublicacion, genero, disponible ? "Sí" : "No");
    }
}
    

