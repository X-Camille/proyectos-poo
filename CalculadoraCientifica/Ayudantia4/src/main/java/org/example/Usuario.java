package org.example;

public class Usuario {

	private Prestamo prestamo;
	private String nombre;
	private String rut;
	private int numero;
	private int telefono;

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return this.rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}

	public int getNumero() {
		return this.numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTelefono() {
		return this.telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Usuario(String nombre, String rut, int numero, int telefono) {
		this.nombre = nombre;
		this.rut = rut;
		this.numero = numero;
		this.telefono = telefono;
	}

}