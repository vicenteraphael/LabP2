package cossenos;
import java.lang.Math;


public class Cosseno {
	public double alfa;
	public double b;
	public double c;
	
	public double a() {
		return Math.sqrt(b * b + c * c - 2 * b * c * Math.cos(Math.toRadians(alfa)));
	}
	
	public String toString() {
		return "alfa = "+ alfa +
				"\nb = " + b +
				"\nc = " + c +
				"\na = " + a();
	}
}
