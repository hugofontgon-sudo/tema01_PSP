package com.hugofont.PSP.tema01;

import java.util.Scanner;

public class Robot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Lee líneas de su entrada estándar hasta recibir fin de fichero (EOF)
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String transformada = linea.toUpperCase() + " [Chars: " + linea.length() + "]";
            System.out.println(transformada);
        }
        scanner.close();
    }
}