package main;

import vetor.Vetor;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre com o valor (a): ");
        double a = scanner.nextDouble();

        System.out.print("Entre com o ângulo (alfa) em graus (°): ");
        double alfa = scanner.nextDouble();

        Vetor vetor = new Vetor(a, alfa);
        System.out.println("\nV:\n" + vetor.toString());

        System.out.println("Vx:\n" + vetor.vetorX().toString());
        System.out.println("Vy:\n" + vetor.vetorY().toString());

        scanner.close();
    }
}
