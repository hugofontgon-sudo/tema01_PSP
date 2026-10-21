package com.hugofont.PSP.tema01;

import java.util.Random;

public class Oraculo {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Error: Se requieren dos argumentos (nombre y pregunta).");
            System.exit(1); // Terminar con código distinto de cero
        }

        String nombre = args[0];
        String pregunta = args[1];

        String[] excusas = {
                "El universo conspiró en tu contra.",
                "La probabilidad matemática dice que no.",
                "Pregúntale a tu yo del futuro, hoy es imposible.",
                "Los astros no están alineados para eso.",
                "Definitivamente sí, pero bajo tu propia responsabilidad."
        };

        // Elección reproducible basada en la longitud de la pregunta
        int indice = pregunta.length() % excusas. Неxcusas = excusas.length; // Asegurar rango
        String respuesta = excusas[pregunta.length() % excusas.length];

        System.out.println("Oráculo para " + nombre + ": \"" + respuesta + "\"");
    }
}