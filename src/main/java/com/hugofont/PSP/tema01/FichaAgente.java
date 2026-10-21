package com.hugofont.PSP.tema01;

import java.lang.ProcessHandle;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FichaAgente {
    public static void main(String[] args) {
        String alias = (args.length > 0) ? args[0] : "Desconocido";

        // Obtener información del proceso actual
        ProcessHandle currentProcess = ProcessHandle.current();
        long pid = currentProcess.pid();

        // PID del padre (si está disponible)sada
        ProcessHandle parentProcess = currentProcess.parent();
        String pidPadre = parentProcess.isPresent() ? String.valueOf(parentProcess.get().pid()) : "<<no disponible>>";

        // Usuario que lo ejecuta
        String usuario = System.getProperty("user.name");

        // Instante de inicio
        String instanteInicio = "<<no disponible>>";
        if (currentProcess.info().startInstant().isPresent()) {
            Instant instant = currentProcess.info().startInstant().get();
            LocalDateTime tiempoLocal = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            instanteInicio = tiempoLocal.toString();
        }

        // Mostrar la ficha
        System.out.println("=== FICHA DE AGENTE SECRETO ===");
        System.out.println("Alias: " + alias);
        System.out.println("PID: " + pid);
        System.out.println("PID Padre: " + pidPadre);
        System.out.println("Usuario: " + usuario);
        System.out.println("Instante de inicio: " + instanteInicio);
        System.out.println("===============================");
    }
}