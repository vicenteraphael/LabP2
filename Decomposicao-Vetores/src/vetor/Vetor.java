package vetor;

import java.lang.Math;

public class Vetor {
    private double a;
    private double alfa;

    public Vetor(double a, double alfa) {
        this.a = a;
        this.alfa = alfa;
    }

    public double getValor() {
        return a;
    }

    public double getModulo() {
        return Math.abs(a);
    }

    public double getAlfa() {
        return alfa;
    }

    public Vetor vetorX() {
        double valor = a * Math.cos(Math.toRadians(alfa));
        return new Vetor(valor, valor >= 0 ? 0 : 180);
    }

    public Vetor vetorY() {
        double valor = a * Math.sin(Math.toRadians(alfa));
        return new Vetor(valor, valor >= 0 ? 90 : 270);
    }

    public String toString() {
        return "a = " + String.format("%.2f", a) + "\nalfa = " + String.format("%.2f", alfa) + "°\n";
    }
}