package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Vetor;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("VETOR 1: ");

        System.out.print("valor = ");
        double valor1 = scanner.nextDouble();

        System.out.print("angulo (°) = ");
        double angulo1 = scanner.nextDouble();


        System.out.println("\nVETOR 2: ");

        System.out.print("valor = ");
        double valor2 = scanner.nextDouble();

        System.out.print("angulo (°) = ");
        double angulo2 = scanner.nextDouble();


        Vetor vetor1 = new Vetor(valor1, angulo1);
        Vetor vetor2 = new Vetor(valor2, angulo2);

        Vetor resultante = Vetor.soma(vetor1, vetor2);

        System.out.println("\nVetor1:\n" + vetor1.toString());
        System.out.println("\nVetor2:\n" + vetor2.toString());
        System.out.println("\nResultante:\n" + resultante.toString());

        scanner.close();
    }
}