package main;
import java.util.Locale;
import java.util.Scanner;
import parabola.Parabola;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre com o valor de (a): ");
        double a = scanner.nextDouble();

        System.out.print("Entre com o valor de (b): ");
        double b = scanner.nextDouble();

        System.out.print("Entre com o valor de (c): ");
        double c = scanner.nextDouble();

        Parabola parabola = new Parabola(a, b, c);

        System.out.println("Concavidade: " + parabola.concavidade);
        System.out.println("Valor de delta: " + parabola.delta);
        System.out.println("Valor de x1: " + parabola.x1);
        System.out.println("Valor de x2: " + parabola.x2);

        scanner.close();
    }   
}
