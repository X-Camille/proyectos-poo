package org.model;

public class Cafe {

	private float gramosCafe;
	private float mililitrosAgua;
	private String tamano;
	private String ingredientes;
	public float getGramosCafe() {
		return gramosCafe;
	}

	public float getMililitrosAgua() {
		return mililitrosAgua;
	}

	public String getTamano(){
		return tamano;
	}

	public String getIngredientes(){
		return ingredientes;
	}

	public Cafe(float gramosCafe, float mililitrosAgua, String tamano, String ingredientes){
		this.gramosCafe = gramosCafe;
		this.mililitrosAgua = mililitrosAgua;
		this.tamano = tamano;
		this.ingredientes = ingredientes;
	}

	public String toString(){
		return getGramosCafe() + "/" + getMililitrosAgua() + "/" + getTamano() + "/" + getIngredientes();
	}

}

