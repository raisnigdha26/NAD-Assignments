package numericalanalysis;

import java.util.Scanner;

public class NAD_Regula_Falsi_method {
    static float fun(float x){
        return x*x-x-1;
    }


    public static void main(String[] args) {
        int i=1;
        float a,b,m,e=0.0001f;
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose equation for root calculation");
        System.out.println("Enter value of a ");
        a= sc.nextFloat();
        System.out.println("Enter value of b ");
        b= sc.nextFloat();


                if(fun(a)*fun(b)>0)
            {
                System.out.println("Invalid Interval");
            }
            else {

                    m = (a * fun(b) - b * fun(a)) / (fun(b) - fun(a));
                    System.out.println("i\t\ta\t\t  b\t\t\t  m\t\t\tf(m)\t\t  f(a)*f(m)");
                    while (Math.abs(fun(m)) > e) {
                        System.out.printf("%d\t%.6f\t%.6f\t%.6f\t%.6f\t  %.6f\n", i, a, b, m, fun(m), fun(a) * fun(m));
                        if (fun(a) * fun(m) > 0) {
                            a = m;
                        }
                        else {
                            b = m;
                        }
                        m = (a * fun(b) - b * fun(a)) / (fun(b) - fun(a));
                        i++;

                    }
                    System.out.printf("%d\t%.6f\t%.6f\t%.6f\t%.6f\t  %.6f\n", i, a, b, m, fun(m), fun(a) * fun(m));
                    System.out.printf("Roots=%f", m);
            }

    }
}
