package linearRegression;
import linearRegression.methods.vtCalc;
import linearRegression.methods.GaussSeidel;

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

        double[][] A = {{n, sumX}, {sumX, sumX2}};
        double[] B = {sumY, sumXY};


        double[] coeficientes = GaussSeidel.gaussSeidel(A, B);


        System.out.println("Coeficiente a: " + coeficientes[0]);
        System.out.println("Coeficiente b: " + coeficientes[1]);
        System.out.printf("Expressão: y= %.2fx + %.2f. \nDomínio: [%.2f, %.2f]", coeficientes[0], coeficientes[1], xArray[0], xArray[xArray.length-1]);

        vtCalc.vtCalcValue(xArray, coeficientes, yArray);

        sc.close();
    }



}
