package linearRegression;

import java.util.Arrays;
import java.util.Scanner;

public class linearPartI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("Informe quantos pares ordenados serão informados: ");
            n = sc.nextInt();
        } while (n <= 0);

        double[] xArray = new double[n];
        double[] yArray = new double[n];
        double[] xyArray = new double[n];
        double[] x2Array = new double[n];

        for (int i = 0; i < xArray.length; i++) {
            System.out.println("Informe o valor da posição " + i + " do array x: ");
            xArray[i] = sc.nextDouble();
        }

        for (int i = 0; i < yArray.length; i++) {
            System.out.println("Informe o valor da posição " + i + " do array y: ");
            yArray[i] = sc.nextDouble();
        }

        for (int i = 0; i < xArray.length; i++) {
            xyArray[i] = xArray[i] * yArray[i];
        }

        for(int i = 0; i < xArray.length; i++){
            x2Array[i] = Math.pow(xArray[i], 2);
        }

        System.out.println("Array x: " + Arrays.toString(xArray));
        System.out.println("Array y: " + Arrays.toString(yArray));
        System.out.println("Array xy:" + Arrays.toString(xyArray));
        System.out.println("Array x²: " + Arrays.toString(x2Array));
        sc.close();
    }
}
