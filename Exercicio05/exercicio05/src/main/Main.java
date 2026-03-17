package main;

import java.util.Scanner;
import java.util.Locale;
import cossenos.Cosseno;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		Cosseno cosseno = new Cosseno();
		
		System.out.print("Entre com alfa (em graus): ");
		cosseno.alfa = scanner.nextDouble();
		
		System.out.print("Entre com b: ");
		cosseno.b = scanner.nextDouble();
		
		System.out.print("Entre com c: ");
		cosseno.c = scanner.nextDouble();
		
		System.out.println(cosseno.toString());
		
		scanner.close();
	}
}
