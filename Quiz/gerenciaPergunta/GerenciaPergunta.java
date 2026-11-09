package gerenciaPergunta;

import pergunta.Pergunta;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GerenciaPergunta {

    public static List<Pergunta> carregarPerguntas(String caminho) throws IOException {
        Path arquivo = Path.of(caminho);

        if (!Files.isRegularFile(arquivo)) {
            throw new IOException("O caminho informado não corresponde a um arquivo.");
        }

        List<String> linhas = Files.readAllLines(arquivo, StandardCharsets.UTF_8);
        List<Pergunta> perguntas = new ArrayList<>();
        List<String> alternativas = new ArrayList<>();

        String enunciado = null;
        int indiceCorreto = -1;

        for (int i = 0; i < linhas.size(); i++) {
            String linha = linhas.get(i).trim();

            if (linha.isEmpty()) {
                if (enunciado != null) {
                    adicionarPergunta(perguntas, enunciado, alternativas, indiceCorreto);
                    enunciado = null;
                    alternativas = new ArrayList<>();
                    indiceCorreto = -1;
                }
                continue;
            }

            if (enunciado == null) {
                enunciado = linha;
            } else {
                boolean correta = linha.startsWith("*");
                if (correta) {
                    if (indiceCorreto != -1) {
                        throw new IllegalArgumentException(
                            "Há mais de uma alternativa correta na pergunta: " + enunciado
                        );
                    }
                    indiceCorreto = alternativas.size();
                    linha = linha.substring(1).trim();
                }

                if (linha.isEmpty()) {
                    throw new IllegalArgumentException(
                        "Foi encontrada uma alternativa vazia na pergunta: " + enunciado
                    );
                }
                alternativas.add(linha);
            }
        }

        // Processa também a última pergunta, mesmo sem linha em branco ao final.
        if (enunciado != null) {
            adicionarPergunta(perguntas, enunciado, alternativas, indiceCorreto);
        }

        return perguntas;
    }

    private static void adicionarPergunta(
        List<Pergunta> perguntas,
        String enunciado,
        List<String> alternativas,
        int indiceCorreto
    ) {
        if (alternativas.size() < 2) {
            throw new IllegalArgumentException(
                "A pergunta deve possuir pelo menos duas alternativas: " + enunciado
            );
        }

        if (indiceCorreto == -1) {
            throw new IllegalArgumentException(
                "Nenhuma alternativa foi marcada como correta na pergunta: " + enunciado
            );
        }

        perguntas.add(new Pergunta(enunciado, alternativas, indiceCorreto));
    }
}
