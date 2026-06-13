package org.iesalandalus.programacion.tp08.modelo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Usuarios {

    private static final String CARPETA_DATOS = "datos";
    private static final String FICHERO_USUARIOS = "usuarios.csv";
    private static final String SEPARADOR_CSV = ";";

    private List<Usuario> coleccionUsuarios = new ArrayList<>();

    public void leer() {
        InputStream is = getClass().getResourceAsStream("/" + CARPETA_DATOS + "/" + FICHERO_USUARIOS);
        if (is == null) {
            System.out.println("No se encuentra el fichero " + CARPETA_DATOS + "/" + FICHERO_USUARIOS);
            return;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String linea;
            int numRegistro = 0;
            while ((linea = br.readLine()) != null) {
                numRegistro++;
                insertar(linea.split(SEPARADOR_CSV), numRegistro);
            }
            System.out.println("Fichero " + CARPETA_DATOS + "/" + FICHERO_USUARIOS + " leido correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR al leer el fichero: " + e.getMessage());
        }
    }

    private void insertar(String[] campos, int numRegistro) {
        if (campos.length != 3) {
            System.out.println("ERROR al procesar el registro número " + numRegistro + ": No tiene los campos necesarios.");
            return;
        }
        try {
            String nombre = campos[0].trim();
            String nick = campos[1].trim();
            LocalDate fechaNacimiento = LocalDate.parse(campos[2].trim(), Usuario.FORMATO_FECHA);
            coleccionUsuarios.add(new Usuario(nombre, nick, fechaNacimiento));
        } catch (DateTimeParseException e) {
            System.out.println("ERROR al procesar el registro número " + numRegistro + ": Formato de fecha incorrecto.");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR al procesar el registro número " + numRegistro + ": " + e.getMessage());
        }
    }

    public List<Usuario> getUsuarios() {
        return new ArrayList<>(coleccionUsuarios);
    }
}