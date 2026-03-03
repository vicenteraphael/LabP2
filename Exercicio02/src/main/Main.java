package main;

import java.util.Locale;
import java.util.Scanner;
import retangulo.Retangulo;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
			
		Retangulo retangulo = new Retangulo();
		
		System.out.print("Entre com a largura do retângulo: ");
		retangulo.largura = scanner.nextDouble();
		
		System.out.print("Entre com o comprimento do retângulo: ");
		retangulo.comprimento = scanner.nextDouble();
		
		System.out.printf("O retângulo supracitado tem área = %.2f\n", retangulo.area());
		System.out.printf("O retângulo supracitado tem perímetro = %.2f\n", retangulo.perimetro());
		
		scanner.close();
	}
}
