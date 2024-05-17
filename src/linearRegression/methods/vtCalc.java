package linearRegression.methods;

public class vtCalc {
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


        System.out.println("\nValores armazenados no vetor:");

        double[] veCalc = new double[resultadosPosicao.length];
        for (int i = 0; i < resultadosPosicao.length; i++) {
             veCalc[i] += Math.pow((resultadosPosicao[i] - yMedia),2);
            System.out.printf("veCalc[%d] = %.3f\n", i, veCalc[i]);
        }

        double somaTotalVe = 0;
        for(double valor: veCalc){
            somaTotalVe += valor;
        }
        System.out.printf("Soma dos elementos de veCalc: %.2f", somaTotalVe);

    }
}
