package retangulo;

public class Retangulo {
	public double largura;
	public double comprimento;

	public double area() {
		return this.largura * this.comprimento;
	}
	
	public double perimetro() {
		return 2 * this.largura + 2 *this.comprimento;
	}
}
