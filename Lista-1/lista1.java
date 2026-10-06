import java.util.Scanner;
import java.util.Locale;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		// 1)
		System.out.println("Questão 1)");
		
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		System.out.print("Idade: ");
		int idade = scan.nextInt();
		System.out.print("Altura: ");
		double altura = scan.nextDouble();
		System.out.println("Nome: "+ nome);
		System.out.println("Idade: "+ idade);
		System.out.println("Altura: "+ altura);
		
		System.out.println("-");
		
		// 2)
		System.out.println("Questão 2)");
			
		final int ANO_ATUAL = 2026;
		System.out.println("Nascimento: " + (ANO_ATUAL-19));
		System.out.println("Ano com 65: " + (ANO_ATUAL-19+65));
		
		System.out.println("-");
		
		// 3)
		// A saída será 10, pois b = a quando a = 10,
		// pela propriedade transitiva da igualdade, a será 10
		
		// 4)
		// NÃO PODE ALTERAR O VALOR DE UMA VARIÁVEL CONSTANTE, BURRO DO CARAI
		
		// 5)
		final double VELOCIDADE_MAXIMA = 80;
		final int NUMERO_MESES_DO_ANO = 12;
		final double PI = 3.14159265358979323846264338327950288419716939937510;
		
		// 6)
		// long
		// double
		// char
		// boolean
		
		// 7)
		// TEM QUE USAR ASPAS SIMPLES PARA CHAR!!!!!
		
		//8)
		// Com o double, dá pra armazenar casas decimais
		
		// 9)
		// 3
		
		// 10)
		// Falta o f no final senão o Java acha que é double (burrão)
		
		// 11)
		// Para ele poder ser executado sem precisar de instância
		
		// 12)
		// Não roda
		
		// 13)
		Programa.main(args);
								   
		// 14)
		// true
								   
		// 15) Letra: J
								   
		// 16)
		// Código fonte é aquele de antes de compilar (.java). Bytecode é o código gerado após a compilação (.class)
								   
		// 17)
		// Ele vai compilar e executar se o arquivo possuir apenas uma classe								   
							   
		// 18)
		// Código fonte > Compilação > Bytecode > Execução pela JVM
								  
		// 19)
		System.out.println("Questão 19)");
		
		System.out.print("Número: ");
		double num = scan.nextDouble();
		System.out.println("Dobro: " + num*2);
		
		System.out.println("-");
	}
	
	// 13)
	public static class Programa {
		public static void main(String[] args) {
			System.out.println("Questão 13)");

			System.out.println("byte: " + (byte)127);
			System.out.println("short: " + (short)32767);
			System.out.println("int: " + (int)1000000);
			System.out.println("long: " + (long)7000000000l);
			System.out.println("float: " + 20.0f);
			System.out.println("double: " + 30.0);
			System.out.println("char: " + 'a');
			System.out.println("boolean: " + false);

			System.out.println("-");
		}
	}
}