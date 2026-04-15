package vetor;

public class Vetor {
    private double valor;
    private double angulo;

    public static soma(Vetor A, Vetor B) {
        double a = A.getModulo();
        double b = B.getModulo();
        //double angulo = Math.toRadians(A.getAngulo()) + Math.toRadians(B.getAngulo());
        //double valor = Math.sqrt(a*a + b*b + 2 * a * b * Math.cos(angulo));

        //return new Vetor(valor, angulo);
    }

    public Vetor(double valor, double angulo) {
        this.valor = valor;
        this.angulo = angulo;
    }

    public double getValor() {
        return valor;
    }

    public double getAngulo() {
        return angulo;
    }

    public double getModulo() {
        if (valor < 0) return -valor;
        return valor;
    }

    public String toString() {
        return "valor = " + valor +
                "\nmodulo = " + getModulo() +
                "\nangulo = " + angulo;
    }
}
