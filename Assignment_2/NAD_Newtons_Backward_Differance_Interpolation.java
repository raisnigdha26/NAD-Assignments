package numericalanalysis;

import java.util.Scanner;

public class NAD_Newtons_Backward_Differance_Interpolation {
    static float numerator(float u, int i) {
        float mul = 1;
        for (int j = 0; j < i; j++) {
            mul *= u + j;
        }
        return mul;
    }

    static int factorial(int n) {
        if (n == 1)
            return 1;
        else
            return n * factorial(n - 1);

    }

    static float[][] difference(float[] y_arr, int n) {
        float d[][] = new float[n+2][n+2];
        for(int j=1;j<=n-1;j++)
        {
            for(int i=1;i<=n-j;i++)
            {
                if(j==1)
                {
                    d[i][j]=y_arr[i+j]-y_arr[i];
                }
                else
                {
                    d[i][j]=d[i+1][j-1]-d[i][j-1];
                }
            }
        }
            System.out.println("Backward Differance Table:");
            for (int i = 1; i <= n - 1; i++) {
                System.out.printf("Ṿ%d\t\t\t\t", i);
            }
            System.out.println("\n");
            for (int i = 1; i <= n - 1; i++) {

                for (int j = 1; j <= n - i; j++) {

                    System.out.print(d[i][j]);
                    System.out.print("\t\t\t\t");
                }
                System.out.println("\n");
            }
            return d;
        }


    static void NBDIF(float[] x_arr, float y_arr[], float x, int n) {

        float h = x_arr[2] - x_arr[1];
        float u = (x - x_arr[n]) / h;
        float[][] d = difference(y_arr, n);

        float result = y_arr[n];
        for (int i = 1; i <= n - 1; i++) {

            result += (numerator(u, i) / factorial(i)) * d[n  - i][i];

        }
        System.out.println(result);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of terms ");
        int n = sc.nextInt();
        float[] x_arr = new float[n + 2];
        float[] y_arr = new float[n + 2];
        float[][] d = new float[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            System.out.printf("Enter value of x%d\t", i);
            x_arr[i] = sc.nextFloat();
            System.out.printf("Enter value of y[%.2f]\t", x_arr[i]);
            y_arr[i] = sc.nextFloat();
        }
        System.out.println("Enter value of x");
        float x = sc.nextFloat();
        NBDIF(x_arr, y_arr, x, n);


    }


}

