package numericalanalysis;

import java.util.Scanner;

public class NAD_Runge_Kutta_4th_Order {
    static float fun(double x,double y) {
        return (float) (x+y);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter initial value of x");
        float x0 = sc.nextFloat();
        System.out.println("Enter initial value of y");
        float y0 = sc.nextFloat();
        System.out.println("Enter jump ie h");
        float h = sc.nextFloat();
        System.out.println("Enter final value of x");
        float xf = sc.nextFloat();
        float k1, k2, k3, k4, k;
        int i = 1;
        System.out.printf("i\t\t\t x\t\t\t  y\n");
        while (x0 <= xf) {
            System.out.printf("%d\t\t %f\t\t %f\n", i, x0, y0);
            k1 = h * fun(x0, y0);
            System.out.println("k1 = "+k1);
            k2 = h * fun(x0 + 0.5 * h, y0 + 0.5 * k1);
            System.out.println("k2 = "+k2);
            k3 = h * fun(x0 + 0.5 * h, y0 + 0.5 * k2);
            System.out.println("k3 = "+k3);
            k4 = h * fun(x0 + h, y0 + k3);
            System.out.println("k4 = "+k4);
            k = (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            System.out.println("k = "+k);
            x0=x0+h;
            y0=y0+k;
            i++;
        }
    }
}
