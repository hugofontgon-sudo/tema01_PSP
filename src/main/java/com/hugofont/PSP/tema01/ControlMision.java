package com.hugofont.PSP.tema01;

import java.io.IOException;
import java.util.Map;

public class ControlMision {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", "com.germangascon.tema01.Starship", "Exploración Alfa");

        // Añadir variable de entorno PLANETA exclusiva para el proceso hijo
        Map<String, String> entorno = pb.environment();
        entorno.put("PLANETA", "Marte");

        pb.inheritIO();

        try {
            Process proceso = pb.start();
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}