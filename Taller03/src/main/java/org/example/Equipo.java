package org.example;
// Completada
import java.util.*;

public class Equipo {

	private Evento evento;
	private String nombre;
	private ArrayList<Atleta> listaAtletas;
	private Disciplina disciplina;

	public Equipo(String nombre, Disciplina disciplina) {
		this.nombre = nombre;
		this.disciplina = disciplina;
	}

	public String getNombre() {
		return nombre;
	}


	public void agregarAtleta(Atleta atleta) {
		listaAtletas.add(atleta);
	}

	public void eliminarAtleta(Atleta atleta) {
		listaAtletas.remove(atleta);
	}

	public void mostrarInformacionEquipo() {
		System.out.println("Evento a participar: " + evento);
		System.out.println("Nombre de equipo " + nombre);
		System.out.println("Lista de atletas asociados al equipo: ");
		for (Atleta atleta : listaAtletas){
			atleta.mostrarInformacionAtleta();
		}
		System.out.println("Disciplina asociada " + disciplina);
	}
}