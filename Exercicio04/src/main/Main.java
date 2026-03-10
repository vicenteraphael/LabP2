package main;

import java.util.Locale;
import java.util.Scanner;
import banco.Banco;

public class Main {
	public static void main(String[] args) {
		// ----------------- Configurações -----------------
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		Banco conta;
		
		// ----------------- Entrada de dados ----------------- 
		System.out.print("Entre com o número da conta: ");
		int numero = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Entre com o nome do usuário: ");
		String nome = scanner.nextLine();
		
		System.out.print("Tem depósito inicial? (y/n): ");
		char resposta = scanner.next().charAt(0);
		
		// ----------------- Criação da conta -----------------
		if (resposta == 'y') {
			System.out.print("Entre com o depósito inicial: ");
			double depositoInicial = scanner.nextDouble();
			conta = new Banco(nome, numero, depositoInicial);
		} else {
			conta = new Banco(nome, numero);
		}
		
		// ----------------- Exibição da conta -----------------
		System.out.println();
		System.out.println("Dados da conta:");
		System.out.println(conta);
		
		// ----------------- Depósito -----------------
		System.out.print("\nEntre com valor de depósito: ");
		double valorDeposito = scanner.nextDouble();
		conta.depositar(valorDeposito);
		System.out.println("Valor atualizado da conta:");
		System.out.println(conta);

		// ----------------- Saque -----------------
		System.out.print("\nEntre com valor de saque: ");
		double valorSaque = scanner.nextDouble();
		conta.sacar(valorSaque);
		System.out.println("Valor atualizado da conta:");
		System.out.println(conta);
		
		scanner.close();
	}
}
