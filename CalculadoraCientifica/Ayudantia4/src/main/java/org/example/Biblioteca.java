package org.example;

import java.util.*;

public class Biblioteca {

    private Collection<Libro> libro;
    private Collection<Usuario> usuario;
    private Collection<Bibliotecario> bibliotecario;
    private Collection<Prestamo> prestamos;
    private ArrayList<Libro> libros;
    private String nombreBiblioteca;
    private String direccionBiblioteca;

    public void mostrarOpciones(){
        System.out.println("Menú:");
        System.out.println("1. Agregar Libro");
        System.out.println("2. Buscar libro por nombre");
        System.out.println("3. Buscar libro por autor");
        System.out.println("4. Generar préstamo");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca UFRO", "Uruguay");
        while (true) {
            biblioteca.mostrarOpciones();
            Scanner scanner = new Scanner(System.in);

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    biblioteca.agregarLibro();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del libro que desea buscar: ");
                    String titulo = scanner.nextLine();
                    biblioteca.buscarLibro(titulo);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del autor del libro que desea buscar: ");
                    String autor = scanner.nextLine();
                    biblioteca.obtenerLibrosPorAutor(autor);
                    break;
                case 4:
                    Usuario usuario = biblioteca.generarUsuario();
                    biblioteca.generarPrestamo(usuario);
                    break;

                case 5:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public void agregarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese la editorial del libro: ");
        String editorial = scanner.nextLine();
        Libro nuevoLibro = new Libro(nombre, autor, editorial);
        libros.add(nuevoLibro);
        System.out.println("Libro " + nombre + " agregado con éxito.");
    }


    public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getNombre().equals(titulo)) {
                System.out.println("Libro encontrado con éxito.");
                System.out.println("Nombre: " + libro.getNombre() + ". Autor: " + libro.getAutor() + ". Editorial: " + libro.getEditorial());
                return libro;
            }
            else {System.out.println("Lo sentimos. No hay resultados de búsqueda para ese libro.");}
        }
        return null;
    }

    public List<Libro> obtenerLibrosPorAutor(String autor) {
        List<Libro> librosPorAutor = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                librosPorAutor.add(libro);
                System.out.println("Libro encontrado con éxito.");
                System.out.println("Nombre: " + libro.getNombre() + ". Autor: " + libro.getAutor() + ". Editorial: " + libro.getEditorial());
            }
            else {System.out.println("Lo sentimos. No hay resultados de búsqueda para ese libro.");}
        }
        return librosPorAutor;
    }

    public Libro libroExiste(String titulo) {
        for (Libro libro : libros) {
            if (libro.getNombre().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public Usuario generarUsuario(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del usuario que hará el préstamo: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el rut del usuario que hará el préstamo: ");
        String rut = scanner.nextLine();
        System.out.println("Ingrese el número de atención del usuario que hará el préstamo: ");
        int numero = scanner.nextInt();
        System.out.println("Ingrese el teléfono del usuario que hará el préstamo: ");
        int telefono = scanner.nextInt();
        System.out.println("Datos del usuario registrados con éxito");
        return new Usuario(nombre, rut, numero, telefono);
    }


    public void generarPrestamo(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro prestado: ");
        Libro libro = libroExiste(scanner.nextLine());
        if (libro != null) {
            Prestamo prestamo = new Prestamo(usuario, libro);
            prestamos.add(prestamo);
            System.out.println("Préstamo generado con éxito");
        }
        else {
            System.out.println("Hubo un problema al generar el préstamo. Inténtelo de nuevo");
        }
    }



    public Biblioteca(ArrayList<Libro> libros, String nombreBiblioteca, String direccionBiblioteca) {
        this.libros = libros;
        this.nombreBiblioteca = nombreBiblioteca;
        this.direccionBiblioteca = direccionBiblioteca;
    }

    public Biblioteca(String nombreBiblioteca, String direccionBiblioteca) {
        this.libros = new ArrayList<Libro>();
        this.usuario = new ArrayList<Usuario>();  // Agrega esta línea
        this.bibliotecario = new ArrayList<Bibliotecario>();  // Agrega esta línea
        this.prestamos = new ArrayList<Prestamo>();  // Agrega esta línea
        this.nombreBiblioteca = nombreBiblioteca;
        this.direccionBiblioteca = direccionBiblioteca;
    }


}