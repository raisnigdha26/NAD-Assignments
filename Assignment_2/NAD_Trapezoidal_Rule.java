package numericalanalysis;

import java.util.Scanner;

public class NAD_Trapezoidal_Rule {
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
        float h =x_arr[2]-x_arr[1];
        float sum= y_arr[1]+y_arr[n];
        for(int i=2;i<n;i++){
            sum=sum+(2*y_arr[i]);
        }
        float integral=(sum*h)/2;
        System.out.println("Result is : "+integral);
    }
}
