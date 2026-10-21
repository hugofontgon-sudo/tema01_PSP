package com.hugofont.PSP.tema01;

public class Starship {
    public static void main(String[] args) {
        // Obtener la variable de entorno PLANETA
        String planeta = System.getenv("PLANETA");
        if (planeta == null || planeta.isEmpty()) {
            planeta = "Tierra (Valor predeterminado)"; // Valor por defecto si no existe
        }

        String argumentoExtra = (args.length > 0) ? args[0] : "MISIÓN_ESTÁNDAR";

        System.out.println("Nave en ruta hacia: " + planeta + " | Mensaje de misión: " + argumentoExtra);
    }
}