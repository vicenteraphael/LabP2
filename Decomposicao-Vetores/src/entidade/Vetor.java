package entidade;

import java.lang.Math;

public class Vetor {
    private final double valor;
    private final double angulo;

    private final double x;
    private final double y;

    public Vetor(double valor, double angulo) {
        this.valor = Math.abs(valor);
        this.angulo = ((angulo % 360) + 360) % 360;
        double anguloRad = Math.toRadians(angulo);

        this.x = valor * Math.cos(anguloRad);
        this.y = valor * Math.sin(anguloRad);
    }

    public double getValor() {
        return valor;
    }

    public double getAngulo() {
        return angulo;
    }

    public double getX() {
        return x;
        
    }

    public double getY() {
        return y;
         
    }

    public String toString() {
        return "valor = " + valor +
                "\nangulo (°) = " + angulo +
                "\nvalorX = " + x +
                "\nvalorY = " + y +
                "\nresultado = " + x + " +/- " + y;
    }
}