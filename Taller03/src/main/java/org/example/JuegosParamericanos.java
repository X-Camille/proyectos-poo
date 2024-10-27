package org.example;
// Clase Principal
import java.util.*;

public class JuegosParamericanos {
    private ArrayList<Atleta> atletas;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Equipo> equipos;
    private ArrayList<Evento> eventos;

    public JuegosParamericanos() {
        atletas = new ArrayList<Atleta>();
        disciplinas = new ArrayList<Disciplina>();
        equipos = new ArrayList<Equipo>();
        eventos = new ArrayList<Evento>();
    }

    public static void main(String[] args) {
        JuegosParamericanos juegos = new JuegosParamericanos();
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            juegos.mostrarOpciones();
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    juegos.registrarAtleta();
                    break;
                case "2":
                    juegos.registrarDisciplina();
                    break;
                case "3":
                    juegos.crearEquipo();
                    break;
                case "4":
                    juegos.crearEvento();
                    break;
                case "5":
                    juegos.asignarAtletas();
                    break;
                case "6":
                    juegos.asignarEquipos();
                    break;
                case "0":
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (!opcion.equalsIgnoreCase("0"));
    }

    public void mostrarOpciones(){
        System.out.println("Menú de Juegos Panamericanos");
        System.out.println("1. Registrar Atleta");
        System.out.println("2. Registrar Disciplina");
        System.out.println("3. Crear Equipo");
        System.out.println("4. Crear Evento");
        System.out.println("5. Asignar Atletas");
        System.out.println("6. Asignar Equipos");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }
    public void registrarAtleta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del atleta: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el país del atleta: ");
        String pais = scanner.nextLine();
        System.out.println("Ingrese la edad del atleta: ");
        int edad = obtenerEdad();

        Atleta atleta = new Atleta(nombre, pais, edad);
        atletas.add(atleta);
        System.out.println("Atleta registrado correctamente");
    }

    public int obtenerEdad(){
        Scanner scanner = new Scanner(System.in);
        int edad;
        do {
            edad = manejarExcepcionDeEntradaInt();
        } while (!edadEsValida(edad));
        return edad;
    }
    public boolean edadEsValida(int edad) {
        if(edad <= 0){
            System.out.println("La edad no puede ser negativa. Inténtelo nuevamente.");
            return false;
        } else if(edad <= 15 || edad > 35){
            System.out.println("La edad no es válida para participar en los Juegos Paramericanos. Inténtelo nuevamente.");
            return false;
        }
        return true;
    }

    private int manejarExcepcionDeEntradaInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Entrada no válida. Por favor, ingrese un número entero positivo: ");
                scanner.next();
            }
        }
    }

    public void registrarDisciplina() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la disciplina: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el número de participantes: ");
        int numeroParticipantes = obtenerParticipantes();
        System.out.println("Ingrese el récord mundial actual: ");
        String recordMundial = scanner.nextLine();
        Disciplina disciplina = new Disciplina(nombre, numeroParticipantes, recordMundial);
        disciplinas.add(disciplina);
        System.out.println("Disciplina registrada correctamente");
    }

    public int obtenerParticipantes(){
        Scanner scanner = new Scanner(System.in);
        int numero;
        do {
            numero = manejarExcepcionDeEntradaInt();
        } while (!numeroEsValido(numero));
        return numero;
    }
    public boolean numeroEsValido(int numero) {
        if(numero <= 0){
            System.out.println("Un equipo debe estar conformado de al menos un participante. Inténtelo nuevamente.");
            return false;
        } else if(numero > 30){
            System.out.println("Número de participantes no válido. Inténtelo nuevamente.");
            return false;
        }
        return true;
    }

    public void crearEquipo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();
        System.out.print("Ingrese el nombre de la disciplina del equipo: ");
        String nombreDisciplina = scanner.nextLine();

        Disciplina disciplinaEncontrada = disciplinaExiste(nombreDisciplina);

        if (disciplinaEncontrada != null) {
            Equipo equipo = new Equipo(nombreEquipo, disciplinaEncontrada);
            equipos.add(equipo);
            System.out.println("Equipo creado correctamente");
        } else {
            System.out.println("La disciplina '" + nombreDisciplina + "' no existe. No se pudo crear el equipo.");
        }
    }

    public Disciplina disciplinaExiste(String nombreDisciplina){
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNombre().equals(nombreDisciplina)) {
                return disciplina;
            }
        }
        return null;
    }

    public void crearEvento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la disciplina del evento: ");
        String nombreDisciplina = scanner.nextLine();
        System.out.print("Ingrese la fecha del evento: ");
        String fecha = scanner.nextLine();

        Disciplina disciplinaEncontrada = disciplinaExiste(nombreDisciplina);

        if (disciplinaEncontrada != null) {
            Evento evento = new Evento(disciplinaEncontrada, fecha);
            eventos.add(evento);
            System.out.println("Evento creado correctamente");
        } else {
            System.out.println("La disciplina '" + nombreDisciplina + "' no existe. No se pudo crear el evento.");
        }
    }

    public void asignarAtletas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del equipo al que desea agregar atleta: ");
        Equipo equipo = buscarEquipo(scanner.nextLine());
        System.out.println("Ingrese el nombre del atleta al que quiere asignar: ");
        Atleta atleta = buscarAtleta(scanner.nextLine());
        if (atleta != null && equipo != null) {
            equipo.agregarAtleta(atleta);
        } else {
            System.out.println("No se pudo asignar el atleta.");
        }

    }
    public Equipo buscarEquipo(String nombreEquipo){
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombreEquipo)) {
                return equipo;
            }
        }
        return null;
    }

    public Atleta buscarAtleta(String nombreAtleta){
        for(Atleta atleta : atletas){
            if(atleta.getNombre().equalsIgnoreCase(nombreAtleta)){
                return atleta;
            }
        }
        return null;
    }

    public void asignarEquipos() {
        // Me faltó tiempo
    }
}
