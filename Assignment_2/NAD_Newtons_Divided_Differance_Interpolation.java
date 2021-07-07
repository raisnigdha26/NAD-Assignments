package numericalanalysis;

import java.util.Scanner;

public class NAD_Newtons_Divided_Differance_Interpolation {

    static float[][] difference(float[] y_arr, float[] x_arr, int n) {
        float d[][] = new float[n + 2][n + 2];
        for (int j = 0; j <= n - 2; j++) {
            for (int i = 0; i <= ((n - 1) - (j - 1)); i++) {
                if (j == 0) {
                    d[i][j] = (y_arr[i + 1] - y_arr[i]) / (x_arr[i + 1] - x_arr[i]);
                } else {
                    d[i][j] = (d[i + 1][j - 1] - d[i][j - 1]) / (x_arr[i + j + 1] - x_arr[i]);
                }
            }
        }
        System.out.println("Divided Differance Table:");
        for (int i = 1; i <= n - 1; i++) {
            System.out.printf("Ꙟ%d\t\t\t\t\t\t", i);
        }
        System.out.println("\n");
        for (int i = 0; i <= n - 2; i++) {

            for (int j = 0; j <= n - 2 - i; j++) {

                System.out.print(d[i][j]);
                System.out.print("\t\t\t\t\t");
            }
            System.out.println("\n");
        }
        return d;
    }

    static float numerator(float x, float x_arr[], int i) {
        float mul = 1;
        for (int j = 0; j <=i+1; j++) {
            mul *= x - x_arr[j];
        }
        return mul;
    }

    static void NDDIF(float[] x_arr, float[] y_arr, float x, int n){
        float[][] d = difference(x_arr, y_arr, n);
        float result = y_arr[0];
        for (int i = 0; i <= n - 1; i++) {

            result += numerator(x, x_arr, i)*d[0][i];

        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of terms ");
        int n= sc.nextInt();
        float[]x_arr = new float[n+2];
        float[]y_arr= new float[n+2];
        float[][]d = new float[n+2][n+2];
        for(int i=0;i<=n-1;i++)
        {
            System.out.printf("Enter value of x%d\t",i);
            x_arr[i]= sc.nextFloat();
            System.out.printf("Enter value of y[%.2f]\t",x_arr[i]);
            y_arr[i]=sc.nextFloat();

        }
        System.out.println("Enter value of x");
        float x = sc.nextFloat();
        NDDIF(x_arr, y_arr, x, n);
    }
}

