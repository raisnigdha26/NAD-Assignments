package numericalanalysis;

import java.util.Scanner;

public class NAD_Jacobi_Method {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter no. of variables in equation");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        float[][] a = new float[n + 2][n + 2];
        float[] oldx = new float[n + 2];
        float[] newx = new float[n + 2];
        for (int i = 1; i <= n; i++) {
            System.out.printf("For equation %d \n", i);
            for (int j = 1; j <= n + 1; j++) {
                System.out.printf("Coefficient a%d ", j);
                a[i][j] = sc.nextInt();
            }
        }
        float e = 0.0001f;
        float E;
        System.out.println("Enter value of maximum iteration");
        int maxit = sc.nextInt();
        float bigerror = 0;
        float relerror=0.0f;
        for (int i = 1; i <= n; i++) {
            oldx[i] = 0;
        }
        for (int k = 1; k <= maxit; k++) {
            bigerror = 0.0f;
            for (int i = 1; i <= n; i++) {
                float sum = 0.0f;
                for (int j = 1; j <= n; j++) {
                    if (i != j) {
                        sum = sum + a[i][j] * oldx[j];
                    }
                }
                newx[i] = (a[i][n + 1] - sum) / a[i][i];
                E= Math.abs((newx[i] - oldx[i]) / newx[i]);
                if (E > bigerror) {
                    bigerror = E;
                }
                relerror=bigerror;
            }
            System.out.printf("for %d rel error is %f\n",k,relerror);
            for (int i = 1; i <= n; i++) {
                oldx[i] = newx[i];
            }
            if(bigerror<=e) {
                System.out.printf("Converge to a solution in %d iterations\n",k);
                for (int i = 1; i <= n; i++) {
                    System.out.printf("x%d= %.4f\n", i, newx[i]);
                }
                System.exit(0);
            }
        }
        System.out.println("Does not Converge in given iteration\n");
        for (int i = 1; i <= n; i++) {
            System.out.printf("x%d= %.4f\n", i, newx[i]);
        }


    }
}