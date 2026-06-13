package org.iesalandalus.programacion.tp08.modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public record Usuario(String nombre, String nick, LocalDate fechaNacimiento) {

    public static final String ER_NOMBRE = "[A-Z][a-z]+(\\s[A-Z][a-z]+)*";
    public static final String ER_NICK = "@[a-z]+";
    public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Usuario {
        validarNombre(nombre);
        validarNick(nick);
        validarFechaNacimiento(fechaNacimiento);
    }

    private static void validarNombre(String nombre) {
        if (nombre == null || !nombre.matches(ER_NOMBRE)) {
            throw new IllegalArgumentException("El formato del nombre no es correcto.");
        }
    }

    private static void validarNick(String nick) {
        if (nick == null || !nick.matches(ER_NICK)) {
            throw new IllegalArgumentException("El formato del nick no es correcto.");
        }
    }

    private static void validarFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("Formato de fecha incorrecto.");
        }
    }

    public int edad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return nombre + " (" + nick + ") - " + fechaNacimiento.format(FORMATO_FECHA);
    }
}