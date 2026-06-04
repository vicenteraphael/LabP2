package irpf;

public abstract class Irpf {
    public static final double[] faixas = {
        2428.80,
        2826.65,
        3751.05,
        4664.68,
    };

    public static final double[] aliquotas = {
        0.0,
        0.075,
        0.15,
        0.225,
        0.275,
    };

    public static final int size = 4;

    public static double desconto(double salarioBruto) {
        if (salarioBruto <= faixas[0]) return 0;

        double descontoIrpf = 0;
        
        double faixa;
        double faixaAnterior = faixas[0];
        double aliquota;

        for (int i = 1; i < size; ++i) {
            faixa = faixas[i];
            aliquota = aliquotas[i];

            if (faixa <= salarioBruto) {
                descontoIrpf += (faixa - faixaAnterior) * aliquota;
            }
            else {
                descontoIrpf += (salarioBruto - faixaAnterior) * aliquota;
                break;
            }
            
            faixaAnterior = faixa;
        }

        if (salarioBruto > faixas[size-1]) descontoIrpf += (salarioBruto - faixas[size-1]) * aliquotas[size];

        return descontoIrpf;
    }

    public static double salarioLiquido(double salarioBruto) {
        return salarioBruto - desconto(salarioBruto);
    }
}
