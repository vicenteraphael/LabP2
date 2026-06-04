package inss;

public abstract class Inss {
    public static final double[] faixas = {
        1621.00,
        2902.84,
        4354.27,
        8475.55
    };

    public static final double[] aliquotas = {
        0.075,
        0.09,
        0.12,
        0.14
    };

    public static final int size = 4;

    public static double desconto(double salarioBruto) {
        if (salarioBruto <= faixas[0]) return 0;

        double descontoInss = 0;
        
        double faixa;
        double faixaAnterior = 0;
        double aliquota;

        for (int i = 0; i < size; ++i) {
            faixa = faixas[i];
            aliquota = aliquotas[i];

            if (faixa <= salarioBruto) {
                descontoInss += (faixa - faixaAnterior) * aliquota;
            }
            else {
                descontoInss += (salarioBruto - faixaAnterior) * aliquota;
                break;
            }
            faixaAnterior = faixa;
        }

        return descontoInss;
    }

    public static double salarioLiquido(double salarioBruto) {
        return salarioBruto - desconto(salarioBruto);
    }
}
