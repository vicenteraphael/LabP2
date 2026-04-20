package entidade;

import java.lang.Math;

public class Vetor {
    private double valor;
    private double anguloGrau;
    private double anguloRad;

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
        this.anguloGrau = ((angulo % 360) + 360) % 360; // Normalizando o ângulo
        this.anguloRad = Math.toRadians(anguloGrau);
    }

    public double getX() {
        return valor * Math.cos(anguloRad);
    }

    public double getY() {
        return valor * Math.sin(anguloRad);
        
    }

    public double getValor() {
        return valor;
    }

    public double getAnguloGrau() {
        return anguloGrau;
    }

    public double getAnguloRad() {
        return anguloRad;
    }

    public String toString() {
        return "valor = " + valor +
                "\nangulo (°) = " + anguloGrau;
    }
}
