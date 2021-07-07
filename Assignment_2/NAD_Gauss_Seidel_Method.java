package numericalanalysis;

import java.util.Scanner;

public class NAD_Gauss_Seidel_Method {
    public static void main(String[] args) {
        int n;


        System.out.println("Enter no. of variables in equation");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        float[][]a = new float[n+2][n+2];
        float []x=new float[n+2];
        for(int i=1;i<=n;i++)
        {
            System.out.printf("For equation %d \n",i);
            for(int j=1;j<=n+1;j++)
            {
                System.out.printf("Coefficient a%d ",j);
                a[i][j]= sc.nextInt();

            }
        }
        System.out.println("Enter value of error E");
        float e=sc.nextFloat();
        System.out.println("Enter value of maximum iteration");
        int maxit= sc.nextInt();
        float big = 0f;
        float relerror=0.0f;
        for(int i=1;i<=n;i++)
        {
            x[i]=0;
        }
        for(int k=1;k<=maxit;k++) {
             big = 0;
             for (int i = 1; i <= n; i++) {
                float sum = 0;
                for (int j = 1; j <= n; j++) {

                    if (j != i) {
                        sum = sum + a[i][j] * x[j];
                    }
                }
                float temp = (a[i][n + 1] - sum) / a[i][i];
                relerror = Math.abs((temp - x[i]) / temp);
                if (relerror > big)
                    big = relerror;
                x[i] = temp;
            }
            System.out.printf("for %d rel error is %f\n",k,relerror);
            if (big <= e) {
                System.out.printf("Convergence to a solution in %d iterations\n",k);
                for (int i = 1; i <= n; i++) {
                    System.out.printf("x%d= %f\n", i, x[i]);
                }
                System.exit(0);
            }
        }

        System.out.println("Does not converge in given maximum iteration");

    }
}
