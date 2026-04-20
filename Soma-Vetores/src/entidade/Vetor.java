package entidade;

import java.lang.Math;

public class Vetor {
    private final double valor;
    private final double angulo;

    private final double x;
    private final double y;

    public static Vetor soma(Vetor A, Vetor B) {
        double valorX = A.getX() + B.getX();
        double valorY = A.getY() + B.getY();

        double valorR = Math.sqrt(valorX * valorX + valorY * valorY);
        double anguloR = Math.atan2(valorY, valorX);
        anguloR = Math.toDegrees(anguloR);
        if (anguloR < 0) anguloR += 360; // Normalizando o ângulo

        return new Vetor(valorR, anguloR);
    }

    public Vetor(double valor, double angulo) {
        this.valor = Math.abs(valor);
        this.angulo = ((angulo % 360) + 360) % 360; // Normalizando o ângulo
        double anguloRad = Math.toRadians(angulo);

        this.x = valor * Math.cos(anguloRad);
        this.y = valor * Math.sin(anguloRad);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
        
    }

    public double getValor() {
        return valor;
    }

    public double getAngulo() {
        return angulo;
    }

    public String toString() {
        return "valor = " + valor +
                "\nangulo (°) = " + angulo;
    }
}
