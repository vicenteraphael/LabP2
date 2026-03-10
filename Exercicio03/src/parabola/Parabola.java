package parabola;
import java.lang.Math;

public class Parabola {
	public double a;
	public double b;
	public double c;

	public double delta;

	public double x1;
	public double x2;

	public String concavidade;
	
	public Parabola(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.delta = b * b - 4 * a * c;

		this.x1 = (- b + Math.sqrt(delta)) / (2 * a);
		this.x2 = (- b - Math.sqrt(delta)) / (2 * a);

		concavidade = a > 0 ? "Voltada para cima" : "voltada para baixo";
	}
}
