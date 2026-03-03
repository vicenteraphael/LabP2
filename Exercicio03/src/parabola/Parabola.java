package parabola;
import java.lang.Math;

public class Parabola {
	public double a;
	public double b;
	public double c;
	
	public double delta() {
		return b * b - 4 * a * c;
	}
	
	public double x1() {
		return (- b + Math.sqrt(delta())) / (2 * a);
	}
	
	public double x2() {
		return (- b - Math.sqrt(delta())) / (2 * a);
	}
}
