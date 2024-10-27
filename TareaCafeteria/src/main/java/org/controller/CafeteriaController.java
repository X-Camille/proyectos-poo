package org.controller;

import org.model.Cafe;
import org.model.Cafeteria;

import java.util.InputMismatchException;

public class CafeteriaController {

    private final Cafeteria cafeteria;

    public CafeteriaController(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

    public boolean recibirDatosCafe(String[] datosCafe) {
        Float[] valoresFloat = manejarExcepcionDeEntradaFloat(datosCafe[0], datosCafe[1]);

        if (valoresFloat.length == 2) {
            float gramos = valoresFloat[0];
            float mililitros = valoresFloat[1];
            String tamano = datosCafe[2];

            if (!comprobarSiCamposVacios(datosCafe) && camposValidos(gramos, mililitros, tamano)) {
                Cafe cafe = new Cafe(gramos, mililitros, datosCafe[2], datosCafe[3]);
                return cafeteria.generarCafe(cafe);
            }
        }
        return false;
    }

    public Float[] manejarExcepcionDeEntradaFloat(String gram, String mili) {
        try {
            float gramos = Float.parseFloat(gram);
            float mililitros = Float.parseFloat(mili);
            return new Float[]{gramos, mililitros};
        } catch (NumberFormatException e) {
            System.err.println("Error: Ingrese valores válidos para gramos y mililitros.");
            return new Float[]{};
        }
    }

    public boolean camposValidos(float gramos, float mililitros, String tamano) {
        if (gramos <= 0 || gramos > 1000) {
            System.err.println("Error: Los gramos de café deben ser mayores a 0 y menores o iguales a 1000.");
            return false;
        }
        if (mililitros <= 0 || mililitros > 1000) {
            System.err.println("Error: Los mililitros de agua deben ser mayores a 0 y menores o iguales a 1000.");
            return false;
        }
        return tamano.equalsIgnoreCase("mediano") || tamano.equalsIgnoreCase("grande") || tamano.equalsIgnoreCase("pequeño");
    }
    public boolean comprobarSiCamposVacios(String[] datosCafes) {
        for (String cafe : datosCafes) {
            if (cafe == null || cafe.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

}