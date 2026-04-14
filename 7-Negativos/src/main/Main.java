package main;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("N = ");
		byte n = scanner.nextByte();
		int[] numeros = new int[n];
		
		for (byte i = 0; i < n; ++i) {
			System.out.print("n"+(i+1)+" = ");
			numeros[i] = scanner.nextInt();
		}
		
		System.out.print("\nNEGATIVOS: ");
		for (byte i = 0; i < n; ++i) {
			if (numeros[i] < 0) {
				System.out.print(numeros[i] + " ");
			}
		}
		
		scanner.close();
	}
}
