package main;

import gerenciaPergunta.GerenciaPergunta;
import pergunta.Pergunta;
import quiz.Quiz;
import quiz.ResultadoQuiz;
import relatorio.Relatorio;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("========== QUIZ ==========");
            System.out.print("Digite o caminho do arquivo de perguntas: ");
            String caminhoPerguntas = scanner.nextLine().trim();

            if (caminhoPerguntas.isEmpty()) {
                System.out.println("O caminho do arquivo não pode estar vazio.");
                return;
            }

            try {
                List<Pergunta> perguntas = GerenciaPergunta.carregarPerguntas(caminhoPerguntas);

                if (perguntas.isEmpty()) {
                    System.out.println("O arquivo não contém perguntas.");
                    return;
                }

                Quiz quiz = new Quiz();
                ResultadoQuiz resultado = quiz.executar(perguntas, scanner);

                Relatorio relatorio = new Relatorio();
                relatorio.gerar(resultado, "resultado.txt");

                System.out.println("\nRelatório salvo em resultado.txt.");

            } catch (IOException | IllegalArgumentException e) {
                System.out.println("Não foi possível executar o quiz: " + e.getMessage());
            }
        }
    }
}
