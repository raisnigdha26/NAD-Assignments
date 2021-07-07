package numericalanalysis;

import java.util.Scanner;

public class NAD_Simpsons_Three_by_Eight_Rule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of terms ");
        int n = sc.nextInt();
        float[] x_arr = new float[n + 2];
        float[] y_arr = new float[n + 2];

        for (int i = 0; i <= n-1; i++) {
            System.out.printf("Enter value of x%d\t", i);
            x_arr[i] = sc.nextFloat();
            System.out.printf("Enter value of y[%.2f]\t", x_arr[i]);
            y_arr[i] = sc.nextFloat();
        }
        float h =x_arr[1]-x_arr[0];
        float sum= y_arr[0]+y_arr[n-1];
        for(int i=1;i<=n-2;i++){
            if(i%3==0)
                sum += 2*y_arr[i];
            else
                sum += 3*y_arr[i];

        }
        float integral = (sum*h*3)/8;
        System.out.println("Result is : "+integral);
    }
}
