package quiz;

import java.util.ArrayList;
import java.util.List;

public class ResultadoQuiz {

    public static class RespostaPergunta {
        private final int numeroPergunta;
        private final String enunciado;
        private final String respostaJogador;
        private final String respostaCorreta;
        private final boolean acertou;

        public RespostaPergunta(
            int numeroPergunta,
            String enunciado,
            String respostaJogador,
            String respostaCorreta,
            boolean acertou
        ) {
            this.numeroPergunta = numeroPergunta;
            this.enunciado = enunciado;
            this.respostaJogador = respostaJogador;
            this.respostaCorreta = respostaCorreta;
            this.acertou = acertou;
        }

        public int getNumeroPergunta() { return numeroPergunta; }
        public String getEnunciado() { return enunciado; }
        public String getRespostaJogador() { return respostaJogador; }
        public String getRespostaCorreta() { return respostaCorreta; }
        public boolean isAcertou() { return acertou; }
    }

    private final List<RespostaPergunta> respostas = new ArrayList<>();

    public void adicionarResposta(RespostaPergunta resposta) {
        respostas.add(resposta);
    }

    public List<RespostaPergunta> getRespostas() {
        return new ArrayList<>(respostas);
    }

    public int getAcertos() {
        int total = 0;
        for (RespostaPergunta resposta : respostas) {
            if (resposta.isAcertou()) total++;
        }
        return total;
    }

    public int getErros() {
        return respostas.size() - getAcertos();
    }

    public int getTotalPerguntas() {
        return respostas.size();
    }
}
