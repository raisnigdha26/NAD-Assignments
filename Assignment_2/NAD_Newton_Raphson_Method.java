package numericalanalysis;

import java.util.Scanner;

public class NAD_Newton_Raphson_Method {
    static float fun(float x){
        return x*x-x-1;
    }
    static float fun2(float x){
        return 2*x;
    }
    public static void main(String[] args) {
        int i=1;
        float a,b,m,e=0.0001f;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value of a ");
        a= sc.nextFloat();
        System.out.println("Enter value of b ");
        b= sc.nextFloat();
        if(Math.abs(fun(a))<Math.abs(fun(b)))
        {
            b=a;
        }
        m = b-(fun(b)/fun2(b));
        System.out.println("i\t\t  b\t\t\t  m\t\t\tf(m)");
        while (Math.abs(fun(m)) > e) {
            System.out.printf("%d\t%f\t%f\t%f\n", i, b, m, fun(m));
            b=m;
            m = b-(fun(b)/fun2(b));
            i++;

        }
        System.out.printf("%d\t%f\t%f\t%f\n", i, b, m, fun(m));
        System.out.printf("Roots=%f", m);
          }
}
