package org.example;
// Completada
import java.util.*;

public class Atleta {

	private Equipo equipo;
	private String nombre;
	private String pais;
	private int edad;
	private ArrayList<Disciplina> listaDisciplinas;

	public String getNombre() {
		return this.nombre;
	}

	public Atleta() {
		listaDisciplinas = new ArrayList<Disciplina>();
	}

	public Atleta(String nombre, String pais, int edad) {
		this.nombre = nombre;
		this.pais = pais;
		this.edad = edad;
		listaDisciplinas = new ArrayList<Disciplina>();
	}

	public void agregarDisciplina(String nombreDisciplina, int numeroParticipantes, String recordMundial) {
		listaDisciplinas.add(new Disciplina(nombreDisciplina, numeroParticipantes, recordMundial));
	}

	public void eliminarDisciplina(String nombreDisciplina) {
		for (Disciplina disciplina : listaDisciplinas) {
			if (disciplina.getNombre().equals(nombreDisciplina)) {
				listaDisciplinas.remove(disciplina);
				break;
			}
		}
	}

	public void mostrarInformacionAtleta() {
		System.out.println("Nombre del atleta: " + nombre);
		System.out.println("País: " + pais);
		System.out.println("Edad: " + edad);
		System.out.println("Disciplinas:");
		for (Disciplina disciplina : listaDisciplinas) {
			disciplina.mostrarInformacionDisciplina();
		}
	}
}
