package quiz;

import pergunta.Pergunta;

import java.util.List;
import java.util.Scanner;

public class Quiz {

    public ResultadoQuiz executar(List<Pergunta> perguntas, Scanner scanner) {
        ResultadoQuiz resultado = new ResultadoQuiz();

        System.out.println("\n========== INÍCIO DO QUIZ ==========");

        for (int i = 0; i < perguntas.size(); i++) {
            Pergunta pergunta = perguntas.get(i);

            System.out.println("\nPergunta " + (i + 1) + ":");
            System.out.println(pergunta.getEnunciado());

            List<String> alternativas = pergunta.getAlternativas();

            for (int j = 0; j < alternativas.size(); j++) {
                System.out.println((j + 1) + ") " + alternativas.get(j));
            }

            int resposta = solicitarResposta(scanner, alternativas.size());
            boolean acertou = resposta - 1 == pergunta.getIndiceCorreto();

            String respostaJogador = alternativas.get(resposta - 1);
            String respostaCorreta = alternativas.get(pergunta.getIndiceCorreto());

            if (acertou) {
                System.out.println("Resposta correta!");
            } else {
                System.out.println("Resposta incorreta.");
                System.out.println("A resposta correta é: " + respostaCorreta);
            }

            resultado.adicionarResposta(
                new ResultadoQuiz.RespostaPergunta(
                    i + 1,
                    pergunta.getEnunciado(),
                    respostaJogador,
                    respostaCorreta,
                    acertou
                )
            );
        }

        System.out.println("\n========== RESULTADO FINAL ==========");
        System.out.println("Total de perguntas: " + resultado.getTotalPerguntas());
        System.out.println("Acertos: " + resultado.getAcertos());
        System.out.println("Erros: " + resultado.getErros());

        return resultado;
    }

    private int solicitarResposta(Scanner scanner, int quantidadeAlternativas) {
        while (true) {
            System.out.print("Digite o número da sua resposta: ");
            String entrada = scanner.nextLine().trim();

            try {
                int resposta = Integer.parseInt(entrada);
                if (resposta >= 1 && resposta <= quantidadeAlternativas) {
                    return resposta;
                }
            } catch (NumberFormatException ignored) {
                // A mensagem de entrada inválida é exibida abaixo.
            }

            System.out.println(
                "Opção inválida. Digite um número entre 1 e " + quantidadeAlternativas + "."
            );
        }
    }
}
