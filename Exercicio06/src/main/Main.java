package main;

import java.util.Scanner;
import java.util.Locale;
import pendulo.Pendulo;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);;
		Scanner scanner = new Scanner(System.in);
		Pendulo pendulo = new Pendulo();
		
		System.out.print("t(s) = ");
		pendulo.t = scanner.nextDouble();
		
		System.out.printf("T = %.5f s\n", pendulo.T());
		scanner.close();
	}
}
