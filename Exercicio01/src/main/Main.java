package main;

import java.util.Locale;
import java.util.Scanner;
import exercicio01.Alunos;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		Alunos alunos = new Alunos();
		
		System.out.print("Digite o nome do aluno: ");
		alunos.nome = scanner.nextLine();
		
		for (int i = 0; i < alunos.qntNotas; ++i) {
			System.out.printf("Digite a %dª nota: ", i + 1);
			alunos.nota[i] = scanner.nextDouble();
			while (alunos.nota[i] < 0 || alunos.nota[i] > 10) {
				System.out.printf("Nota inválida! Digite novamente a %d nota:", i + 1);
				alunos.nota[i] = scanner.nextDouble();
			}
		}
		
		System.out.printf("Nota final: %.2f", alunos.notafinal());
		
		if (alunos.pontosfaltantes() != 0) {
			System.out.println("Aprovado!");
		} else {
			System.out.println("Reprovado!");
			System.out.printf("%.2f pontos faltantes", alunos.pontosfaltantes());
		}
		
		scanner.close();
	}
}