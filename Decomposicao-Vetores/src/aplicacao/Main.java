package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Vetor;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre com o valor (a): ");
        double a = scanner.nextDouble();

        System.out.print("Entre com o ângulo (alfa) em graus (°): ");
        double alfa = scanner.nextDouble();

        Vetor vetor = new Vetor(a, alfa);
        System.out.println("\nVETOR:\n" + vetor.toString());

        scanner.close();
    }
}
