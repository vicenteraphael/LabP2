package relatorio;

import quiz.ResultadoQuiz;
import quiz.ResultadoQuiz.RespostaPergunta;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Relatorio {

    public void gerar(ResultadoQuiz resultado, String caminho) throws IOException {
        List<String> linhas = new ArrayList<>();

        linhas.add("========== RELATÓRIO DO QUIZ ==========");
        linhas.add("");
        linhas.add("Total de perguntas: " + resultado.getTotalPerguntas());
        linhas.add("Acertos: " + resultado.getAcertos());
        linhas.add("Erros: " + resultado.getErros());
        linhas.add("");
        linhas.add("========== DETALHAMENTO ==========");
        linhas.add("");

        for (RespostaPergunta resposta : resultado.getRespostas()) {
            linhas.add(
                "Pergunta " + resposta.getNumeroPergunta() + ": "
                + (resposta.isAcertou() ? "ACERTOU" : "ERROU")
            );
            linhas.add("Enunciado: " + resposta.getEnunciado());
            linhas.add("Sua resposta: " + resposta.getRespostaJogador());

            if (!resposta.isAcertou()) {
                linhas.add("Resposta correta: " + resposta.getRespostaCorreta());
            }

            linhas.add("");
        }

        Files.write(Path.of(caminho), linhas, StandardCharsets.UTF_8);
    }
}
