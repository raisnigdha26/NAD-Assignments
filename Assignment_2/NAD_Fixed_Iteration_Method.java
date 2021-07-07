package numericalanalysis;

import java.util.Scanner;

public class NAD_Fixed_Iteration_Method {
    static float fun(float x){
        return x*x-x-1;
    }
    static float fun1(float x){
        return (float) Math.pow(x+1,0.5);
    }
    public static void main(String[] args) {
        int i=1;
        float a,m,e=0.0001f;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value of a ");
        a= sc.nextFloat();
        m=fun1(a);
        System.out.println("i\t\t b\t\t\t  m\t\t\t m-b");
        while(Math.abs(fun(m))>e)
        {
            System.out.printf("%d\t%.6f\t%.6f\t%.6f\n",i,a,m,Math.abs(m-a));
            a=m;
            m=fun1(a);
            i++;

        }
        System.out.printf("%d\t%.6f\t%.6f\t%.6f\n",i,a,m,Math.abs(m-a));
        System.out.printf("Roots=%f",m);
    }

}
