package pendulo;

import java.lang.Math;

public class Pendulo {
	public static final double k = 10;
	public static final double w = 2 * Math.PI;
	public static final double b = 0;
	
	public double t;
	
	public double T(){
		return k * Math.sin(w * t + b);
	}
	
}
