package com.hugofont.PSP.tema01;

import java.io.IOException;

public class InvocarOraculo {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp",
                "bin", // O la ruta donde tengas compiladas tus clases
                "com.germangascon.tema01.Oraculo",
                "Ana",
                "¿Por qué el cielo es azul?"
        );

        // Dejar visible su salida mediante inheritIO()
        pb.inheritIO();

        try {
            Process proceso = pb.start();
            int codigoSalida = proceso.waitFor();
            System.out.println("El proceso hijo terminó con el código de salida: " + codigoSalida);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}