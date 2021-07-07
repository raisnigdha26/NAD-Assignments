package numericalanalysis;

import java.util.Scanner;

public class NAD_Lagrengee_Interpolation_Formula {
    static float numerator(float x_arr[],float x,int i,int n)
    {
        float mul=1;
        for(int j=1;j<=n;j++)
        {
            if(j!=i)
                mul *= x - x_arr[j];
        }
        return mul;
    }
    static float denominator(float x_arr[],float x,int i,int n)
    {
        float total=1;
        for(int j=1;j<=n;j++)
        {
            if(j!=i)
                total *= x_arr[i] - x_arr[j];
        }
        return total;
    }
     static void LI(float x_arr[], float y_arr[], float x, int n)
    {
        float result=0;
        for(int i=1;i<=n;i++)
        {
            result = result + (numerator(x_arr, x, i, n) / denominator(x_arr, x, i, n) * y_arr[i]);
        }
        System.out.printf("Value at point %.2f is %.2f",x,result);
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
        LI(x_arr,y_arr,x,n);
    }
}
