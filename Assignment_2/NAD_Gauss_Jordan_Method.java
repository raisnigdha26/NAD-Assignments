package numericalanalysis;

import java.util.Scanner;

public class NAD_Gauss_Jordan_Method {
    public static void main(String[] args) {
        int n;
        float u;
        System.out.println("Enter no. of variables in equation");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        float[][] a = new float[n+2][n+2];
        float[] x = new float[n+2];
        System.out.println("Format:- x1+x2=x3");
        System.out.println("Read system of equation ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("For equation %d \n", i);
            for (int j = 1; j <= n + 1; j++) {

                a[i][j] = sc.nextFloat();

            }
        }
        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n; i++) {
                u = a[i][k] / a[k][k];
                if (i != k) {
                for (int j = k; j <= n + 1; j++) {

                    a[i][j] = a[i][j] - a[k][j] * u;
                 }

                }
            }
        }
                for (int i = 1; i <= n; i++) {
                    x[i] = a[i][n + 1] / a[i][i];
                    System.out.format("x[%d] =%.4f\n", i, x[i]);
                }
            }
        }

