package alunos;

public class Alunos {
	public String nome;
	public final int qntNotas = 4;
	public double[] nota;
	
	public Alunos() {
		this.nota = new double[this.qntNotas];
	}
	
	public double notafinal() {
		double soma = 0;
		for (int i = 0; i < this.qntNotas; ++i) {
			soma += this.nota[i];
		}
		return soma / this.qntNotas;
	}
	
	public double pontosfaltantes() {
		if (notafinal() < 6) return 6 - notafinal();
		return 0.0;
	}
}