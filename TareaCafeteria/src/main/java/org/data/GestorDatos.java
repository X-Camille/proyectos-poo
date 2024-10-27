package org.data;

import org.model.Cafe;
import org.model.Cafeteria;

import java.io.*;
import java.util.ArrayList;

public class GestorDatos {

    private String[] lineas;

    public ArrayList<Cafe> leerArchivoCafes(String direccionArchivo) {
        ArrayList<Cafe> cafes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(direccionArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("/");

                if (datos.length >= 3) {
                    Cafe cafe = new Cafe(Float.parseFloat(datos[0]), Float.parseFloat(datos[1]), datos[2], datos[3]);
                    cafes.add(cafe);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (cafes.isEmpty()) {
            System.out.println("No se encontraron datos en el archivo.");
        }
        return cafes;
    }

    public boolean registrarDato(Object objeto, String direccionArchivo) {
        boolean lineaVacia=false;
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                lineaVacia=true;
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);

            if(!lineaVacia){
                bw.newLine();
            }
            bw.write(objeto.toString());
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar dato, favor contactar con administrador");
            return false;
        }
    }

    public Cafeteria leerArchivoCafeteria() {
        Cafeteria cafeteria = null;
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Lenovo/Desktop/cafeteria.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("/");

                if (datos.length >= 3) {
                    cafeteria = new Cafeteria(datos[0], datos[1], datos[2]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (cafeteria == null) {
            System.out.println("No se encontraron datos en el archivo.");
        }
        return cafeteria;
    }

    public boolean reescribirDatosCafeteria(Object objeto, String direccionArchivo) {
        try {
            File file = new File(direccionArchivo);
            FileWriter fw = new FileWriter(file, false); // Establecer el parámetro de append como 'false' para sobrescribir el archivo
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(objeto.toString());
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar dato, favor contactar con administrador");
            return false;
        }
    }

    public void reescribirDatosCafes(ArrayList<Cafe> cafes, String direccionArchivo) {
        try {
            File file = new File(direccionArchivo);
            FileWriter fw = new FileWriter(file, false); // Sobrescribe el archivo
            BufferedWriter bw = new BufferedWriter(fw);

            for (Cafe cafe : cafes) {
                String linea = cafe.getGramosCafe() + "/" + cafe.getMililitrosAgua() + "/" + cafe.getTamano() + "/" + cafe.getIngredientes();
                bw.write(linea);
                bw.newLine(); // Agregar nueva línea después de cada café
            }

            bw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}