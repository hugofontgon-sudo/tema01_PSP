package com.hugofont.PSP.tema01;

public class Mascota {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.exit(1);
        }
        String nombre = args[0];
        int pasos = Integer.parseInt(args[1]);
        long pid = ProcessHandle.current().pid();

        for (int i = 1; i <= pasos; i++) {
            System.out.println("PID: " + pid + " | Mascota: " + nombre + " | Paso: " + i);
            try {
                Thread.sleep(200); // Pequeña pausa para simular la carrera
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}