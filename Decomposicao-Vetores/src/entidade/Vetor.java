package entidade;

import java.lang.Math;

public class Vetor {
    private double valor;
    private double anguloGrau;
    private double anguloRad;

    public Vetor(double valor, double angulo) {
        this.valor = Math.abs(valor);
        this.anguloGrau = ((angulo % 360) + 360) % 360;
    }

    public double getValor() {
        return valor;
    }

    public double getAnguloGrau() {
        return anguloGrau;
    }

    public double getX() {
        return valor * Math.cos(anguloRad);
        
    }

    public double getY() {
        return valor * Math.sin(anguloRad);
         
    }

    public String toString() {
        return "valor = " +
                "\nangulo (°) = " + anguloGrau +
                "valorX = " + getX() +
                "valory = " + getX() +
                "resultado = " + getX() + " +/- " + getY();
    }
}