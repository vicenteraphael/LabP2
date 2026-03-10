package banco;

public class Banco {
	// ----------------- Atributos -----------------
	private String nome;
	private int matricula;
	private double saldo;
	
	// ----------------- Construtor -----------------
	public Banco(String nome, int matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public Banco(String nome, int matricula, double depositoInicial) {
		this.nome = nome; 
		this.matricula = matricula;
		depositar(depositoInicial);
	}
	
	// ----------------- Para string -----------------
	public String toString() {
		return "Nome: " + nome +
				"\nConta: " + matricula +
				"\nSaldo: R$ " + String.format("%.2f", saldo);
	}
	
	// ----------------- Getters & Setters -----------------
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public int getMatricula() {
		return this.matricula;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	
	// ----------------- Métodos -----------------
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public void sacar(double valor) {
		this.saldo -= valor;
	}
}
