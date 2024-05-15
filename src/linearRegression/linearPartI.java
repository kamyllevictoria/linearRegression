package linearRegression;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class linearPartI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        int n;
        do {
            System.out.println("Informe quantos pares ordenados serão informados: ");
            n = sc.nextInt();
        } while (n <= 0);


        double[] xArray = new double[n];
        double[] yArray = new double[n];
        double[] xyArray = new double[n];
        double[] x2Array = new double[n];
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;


        for (int i = 0; i < n; i++) {
            System.out.println("Informe o valor de x para o par ordenado " + (i + 1) + ": ");
            xArray[i] = sc.nextDouble();

            System.out.println("Informe o valor de y para o par ordenado " + (i + 1) + ": ");
            yArray[i] = sc.nextDouble();


            xyArray[i] = xArray[i] * yArray[i];
            x2Array[i] = Math.pow(xArray[i], 2);


            sumX += xArray[i];
            sumY += yArray[i];
            sumXY += xyArray[i];
            sumX2 += x2Array[i];
        }

        System.out.println("Array x: " + Arrays.toString(xArray));
        System.out.println("Array y: " + Arrays.toString(yArray));
        System.out.println("Array xy: " + Arrays.toString(xyArray));
        System.out.println("Array x²: " + Arrays.toString(x2Array));
        System.out.println("Soma x: " + sumX);
        System.out.println("Soma y: " + sumY);
        System.out.println("Soma x²: " + sumX2);
        System.out.println("Soma xy: " + sumXY);


        double[][] A = {{n, sumX}, {sumX, sumX2}};
        double[] B = {sumY, sumXY};


        double[] coeficientes = gaussSeidel(A, B);


        System.out.println("Coeficiente a: " + coeficientes[0]);
        System.out.println("Coeficiente b: " + coeficientes[1]);

        System.out.printf("Expressão: y= %.2fx + %.2f. \nDomínio: [%.2f, %.2f]", coeficientes[0], coeficientes[1], xArray[0], xArray[xArray.length-1]);

        veCalc(xArray, coeficientes);

        sc.close();
    }


    public static double[] gaussSeidel(double[][] A, double[] B) {
        int tamanho = A.length;
        double[] aproximacao = new double[tamanho];
        double[] anterior = new double[tamanho];
        Arrays.fill(aproximacao, 0);
        Arrays.fill(anterior, 0);

        double erro = 1e-15;
        int iteracoes = 0;

        while (true) {
            for (int i = 0; i < tamanho; i++) {
                double soma = B[i];
                for (int j = 0; j < tamanho; j++) {
                    if (j != i) {
                        soma -= A[i][j] * aproximacao[j];
                    }
                }
                aproximacao[i] = soma / A[i][i];
            }

            iteracoes++;
            if (iteracoes == 1) {
                continue;
            }

            boolean pare = true;
            for (int i = 0; i < tamanho && pare; i++) {
                if (Math.abs(aproximacao[i] - anterior[i]) > erro) {
                    pare = false;
                }
            }

            if (pare || iteracoes == 1000) {
                break;
            }

            anterior = aproximacao.clone();
        }

        return aproximacao;
    }

    public static void veCalc(double[] xArray, double[] coeficientes) {
        System.out.println("Valores de ye: (y^-ymedia)²");

        double ySoma = 0;

        for (int i = 0; i < xArray.length; i++) {
            double resultado = coeficientes[1] * xArray[i] + coeficientes[0];
            ySoma += resultado;
            double yMedia = ySoma / xArray.length;
            System.out.printf("Para x = %.3f, y = %.3f\n", xArray[i], resultado);
            System.out.println(yMedia);
        }
    }

}
