package numericalanalysis;

import java.util.Scanner;

public class NAD_Gaussian_Quadrature_Formula {
    static float fun(float x) {
        return ((5 * x * x * x )- (3 * x * x )+ (2 * x )+ 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of lower limit");
        float a = sc.nextFloat();
        System.out.println("Enter value of upper limit");
        float b = sc.nextFloat();
        System.out.println("Enter number of terms ");
        int n = sc.nextInt();
        double[] w = new double[n + 2];
        double[] x = new double[n + 2];
        if(n==1)
        {
            w[1]=2;
            x[1]=0;
        }
        else if(n==2)
        {
            w[1]=1; w[2]=1;
            x[1]= 0.5773502692;x[2]= -0.5773502692;
        }
       else if (n == 3) {
            w[1]= 0.8888888889; w[2]=0.5555555556; w[3]=0.5555555556;
            x[1]=0; x[2]=0.7745966692; x[3]=-0.7745966692;
        }
        else if (n == 4) {
            w[1]=0.6521451549; w[2]=0.6521451549; w[3]=0.3478548451; w[4]=0.3478548451;
            x[1]=0.3399810436; x[2]=-0.3399810436; x[3]=0.8611363116; x[4]=-0.8611363116;
        }
       else if (n == 5) {
            w[1]=0.5688888889; w[2]=0.4786286705; w[3]=0.4786286705; w[4]=0.2369268851; w[5]=0.2369268851;
            x[1]=0; x[2]=0.5384693101; x[3]=-0.5384693101; x[4]=0.9061798459; x[5]=-0.9061798459;
        }
        else if (n == 6) {
            w[1]=0.171324492; w[2]=0.360761573; w[3]=0.467913935; w[4]=0.467913935; w[5]=0.360761573; w[6]=0.171324492;
            x[1]=-0.932469514; x[2]=-0.661209386; x[3]=-0.238619186; x[4]=0.238619186; x[5]=0.661209386; x[6]=0.932469514;
        }
       else {
            System.out.println("Enter valid value for n");
            System.exit(0);
        }
        float f;
        float P,Q;
        float integral = 0.0f;
        P = (a + b) / 2;
        Q = (b - a) / 2;
        for (int i = 1; i <n+1; i++) {
           // System.out.printf("value of x[%d] is %.9f\n",i,x[i]);
            float para = (float) (P + Q * x[i]);
            f= fun(para);
            System.out.printf("f%d = %f\n",i,f);
           // System.out.printf("value of w[%d] is %.9f\n",i,w[i]);
            integral = (float) (integral + w[i] * f);
            System.out.printf("integral %f\n",integral);
        }
        integral = Q * integral;
        System.out.println(integral);
    }
}

