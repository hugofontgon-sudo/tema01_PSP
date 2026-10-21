package com.hugofont.PSP.tema01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hipodromo {
    public static void main(String[] args) {
        List<Process> procesos = new ArrayList<>();

        // Lanzar tres mascotas como procesos hijos antes de esperar a ninguna
        try {
            ProcessBuilder pb1 = new ProcessBuilder("java", "-cp", "bin", "com.germangascon.tema01.Mascota", "Tortuga", "5");
            ProcessBuilder pb2 = new ProcessBuilder("java", "-cp", "bin", "com.germangascon.tema01.Mascota", "Liebre", "5");
            ProcessBuilder pb3 = new ProcessBuilder("java", "-cp", "bin", "com.germangascon.tema01.Mascota", "Guepardo", "5");

            pb1.inheritIO();
            pb2.inheritIO();
            pb3.inheritIO();

            procesos.add(pb1.start());
            procesos.add(pb2.start());
            procesos.add(pb3.start());

            // Esperar y anunciar llegadas a medida que van terminando (sin asumir orden estricto)
            System.out.println("--- ¡COMIENZA LA CARRERA! ---");
            while (!procesos.isEmpty()) {
                for (int i = 0; i < procesos.size(); i++) {
                    Process p = procesos.get(i);
                    if (!p.isAlive()) {
                        System.out.println("--> Una mascota ha llegado a la meta. Código de salida: " + p.exitValue());
                        procesos.remove(i);
                        i--;
                    }
                }
                Thread.sleep(100);
            }
            System.out.println("--- ¡CARRERA FINALIZADA! ---");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}