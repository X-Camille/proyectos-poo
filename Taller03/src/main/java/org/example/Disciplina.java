package org.example;
// Completada
public class Disciplina {
	private String nombre;
	private int numeroParticipantes;
	private String recordMundial;

	public Disciplina(String nombre, int numeroParticipantes, String recordMundial) {
		this.nombre = nombre;
		this.numeroParticipantes = numeroParticipantes;
		this.recordMundial = recordMundial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroParticipantes() {
		return numeroParticipantes;
	}

	public void setNumeroParticipantes(int numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}

	public String getRecordMundial() {
		return recordMundial;
	}

	public void setRecordMundial(String recordMundial) {
		this.recordMundial = recordMundial;
	}

	public void mostrarInformacionDisciplina() {
		System.out.println("Nombre de la disciplina: " + nombre);
		System.out.println("Número de participantes: " + numeroParticipantes);
		System.out.println("Record Mundial: " + recordMundial);
	}
}
