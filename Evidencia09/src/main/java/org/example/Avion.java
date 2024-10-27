import java.util.*;

public class Avion {

	private Collection<Aeropuerto> aeropuerto;
	private Collection<Vuelo> vuelos;
	private String nombre;
	private int ano;
	private double kmRecorridos;

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAno() {
		return this.ano;
	}

	/**
	 * 
	 * @param ano
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getKmRecorridos() {
		return this.kmRecorridos;
	}

	/**
	 * 
	 * @param kmRecorridos
	 */
	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

}