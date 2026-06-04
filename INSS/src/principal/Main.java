package principal;

import java.util.Locale;
import java.util.Scanner;
import inss.Inss;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Salário Bruto: ");
        double salarioBruto = scanner.nextDouble();

        System.out.println("Olá " + nome);
        System.out.println("Seu desconto INSS é ");
        System.out.printf("R$ %.2f\n", Inss.desconto(salarioBruto));
        System.out.println("Seu salário líquido é ");
        System.out.printf("R$ %.2f\n", Inss.salarioLiquido(salarioBruto));

        scanner.close();
    }
}
