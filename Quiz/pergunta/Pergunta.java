package pergunta;

import java.util.ArrayList;
import java.util.List;

public class Pergunta {
    private final String enunciado;
    private final List<String> alternativas;
    private final int indiceCorreto;

    public Pergunta(String enunciado, List<String> alternativas, int indiceCorreto) {
        this.enunciado = enunciado;
        this.alternativas = new ArrayList<>(alternativas);
        this.indiceCorreto = indiceCorreto;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getAlternativas() {
        return new ArrayList<>(alternativas);
    }

    public int getIndiceCorreto() {
        return indiceCorreto;
    }
}
