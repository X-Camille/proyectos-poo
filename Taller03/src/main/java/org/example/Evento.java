package org.example;
// Completada
import java.util.*;

public class Evento {

	private ArrayList<Atleta> atletas;
	private Disciplina disciplina;
	private ArrayList<Equipo> equipos;
	private String fecha;

	public Evento(Disciplina disciplina, String fecha){
		this.disciplina = disciplina;
		this.fecha = fecha;
	}

	public void agregarAtleta(Atleta atleta) {
		atletas.add(atleta);
	}

	public void eliminarAtleta(Atleta atleta) {
		atletas.add(atleta);
	}

	public void mostrarInformacionEvento() {
		System.out.print("Atletas que participarán en el evento: ");
		for (Atleta atleta : atletas){
			atleta.mostrarInformacionAtleta();
		}
		System.out.println("Disciplina asociada al evento: " + disciplina);
		System.out.println("Equipos asociados al evento: ");
		for (Equipo equipo : equipos){
			equipo.mostrarInformacionEquipo();
		}
		System.out.println("Fecha del evento: " + fecha);
	}

}