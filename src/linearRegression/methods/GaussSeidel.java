package linearRegression.methods;

import java.util.Arrays;

public class GaussSeidel {
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

            boolean pare = true;
            for (int i = 0; i < tamanho; i++) {
                if (Math.abs(aproximacao[i] - anterior[i]) > erro) {
                    pare = false;
                    break;
                }
            }

            if (pare || iteracoes == 1000) {
                break;
            }

            anterior = aproximacao.clone();
        }

        return aproximacao;
    }
}
