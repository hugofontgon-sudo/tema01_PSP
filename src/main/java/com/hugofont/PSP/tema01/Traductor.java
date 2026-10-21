package com.hugofont.PSP.tema01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Traductor {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", "com.germangascon.tema01.Robot");

        try {
            Process proceso = pb.start();

            // Enviar al menos tres mensajes a través del flujo de entrada del hijo
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()))) {
                writer.write("hola humano\n");
                writer.write("procesando datos\n");
                writer.write("fin de transmision\n");
                writer.flush();
                // Cerrar el flujo de entrada para indicar EOF al proceso hijo
            }

            // Leer todas las respuestas devueltas por el robot
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                System.out.println("--- RESPUESTAS DEL ROBOT ---");
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
            }

            proceso.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}