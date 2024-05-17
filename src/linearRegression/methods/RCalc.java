package linearRegression.methods;

import java.util.Arrays;

public class RCalc {
    public static void vtCalcValue(double[] xArray, double[] coeficientes, double[] yArray) {
        System.out.println("\nValores:");

        double ySoma = 0;
        double yMedia = 0;
        double[] resultadosPosicao = new double[xArray.length];

        for (int i = 0; i < xArray.length; i++) {
            double resultado = coeficientes[1] * xArray[i] + coeficientes[0];
            resultadosPosicao[i] = resultado;
            ySoma += resultado;
            yMedia = ySoma / xArray.length;
            System.out.printf("Para x = %.3f, y = %.3f\n", xArray[i], resultado);
        }

        System.out.println("Soma total dos valores: " + ySoma);
        System.out.println("Media final aproximada: " + yMedia);


        //System.out.println("Valores armazenados no vetor:");

        double[] veCalc = new double[resultadosPosicao.length];
        for (int i = 0; i < resultadosPosicao.length; i++) {
            veCalc[i] += Math.pow((resultadosPosicao[i] - yMedia), 2);
            //System.out.printf("veCalc[%d] = %.3f\n", i, veCalc[i]);
        }

        double somaTotalVe = 0;
        for (double valor : veCalc) {
            somaTotalVe += valor;
        }
        System.out.printf("Soma dos elementos de veCalc: %.2f", somaTotalVe);


        double[] vneArray = new double[yArray.length];
        double vneSoma = 0;
        double vneCalc = 0;
        double vneSomaFinal = 0;
        double[] vneFinal = new double[yArray.length];

        for (int i = 0; i < yArray.length; i++) {
            double vneResultado = coeficientes[1] * xArray[i] + coeficientes[0];
            vneArray[i] = vneResultado;
            vneSoma += vneResultado;

            double resultadoSubtracao = Math.pow((vneArray[i] - yArray[i]),2);
            vneSomaFinal += resultadoSubtracao;
            //System.out.printf("\nResultado da subtração de %.2f - %.2f = %.2f", vneResultado, yArray[i], resultadoSubtracao);
        }
        System.out.printf("\nValor de VNE DE FATO: %.2f", vneSomaFinal);

        double R = 100.0 * somaTotalVe/ somaTotalVe +vneSomaFinal;
        System.out.printf("\nValor de R²: %.2f %%.", R);


    }
}
