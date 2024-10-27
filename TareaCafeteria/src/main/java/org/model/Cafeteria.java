package org.model;

import org.data.GestorDatos;

import java.util.ArrayList;
import java.util.Scanner;

public class Cafeteria {

	private String nombre;
	private String direccion;
	private String redesSociales;
	private ArrayList<Cafe> cafes;


	public String getNombre(){
		return nombre;
	}

	public String getDireccion(){
		return direccion;
	}

	public String getRedesSociales(){
		return redesSociales;
	}

	public ArrayList<Cafe> getCafes(){
		return cafes;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setDireccion(String direccion){
		this.direccion = direccion;
	}

	public void setRedesSociales(String redesSociales){
		this.redesSociales = redesSociales;
	}

	public void setCafes(ArrayList<Cafe> cafes){
		this.cafes = cafes;
	}

	public Cafeteria(String nombre, String direccion, String redesSociales) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.redesSociales = redesSociales;
		cafes = new ArrayList<Cafe>(){};
	}

	public void agregarCafe(Cafe cafe) {
		cafes.add(cafe);
	}

	public ArrayList<Cafe> buscarCafesPorTamano(String busqueda) {
		GestorDatos file = new GestorDatos();
		ArrayList<Cafe> cafesEncontrados = new ArrayList<>();

		cafes = file.leerArchivoCafes("C:/Users/Lenovo/Desktop/cafes.txt");

		for (Cafe cafe : cafes) {
			System.out.println(busqueda);
			System.out.println(cafe.getTamano());
			if (cafe.getTamano().equalsIgnoreCase(busqueda)) {
				System.out.println("Café encontrado con éxito.");
				cafesEncontrados.add(cafe);
			}
		}
		return cafesEncontrados;
	}

	public void discontinuarCafe(Cafe cafeSeleccionado) {
		GestorDatos file = new GestorDatos();
		cafes.remove(cafeSeleccionado);
		file.reescribirDatosCafes(cafes, "C:/Users/Lenovo/Desktop/cafes.txt");
	}


	public boolean generarCafe(Cafe cafe) {
		Scanner scanner = new Scanner(System.in);
		GestorDatos file = new GestorDatos();
		if (cafe != null) {
			file.registrarDato(cafe, "C:/Users/Lenovo/Desktop/cafes.txt");
			System.out.println("Café agregado con éxito");
			return true;
		}
		else {
			System.out.println("Hubo un problema al agregar el café. Inténtelo de nuevo");
			return false;
		}
	}

	public String toString(){
		return getNombre() + "/" + getDireccion() + "/" + getRedesSociales();
	}
}