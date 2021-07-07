package numericalanalysis;

import java.util.Scanner;

public class NAD_Divided_Differance_Table {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of terms ");
        int n= sc.nextInt();
        float[]x = new float[n+2];
        float[]y = new float[n+2];
        float[][]d = new float[n+2][n+2];
        for(int i=0;i<=n-1;i++)
        {
            System.out.printf("Enter value of x%d\t",i);
            x[i]= sc.nextFloat();
            System.out.printf("Enter value of y[%.2f]\t",x[i]);
            y[i]=sc.nextFloat();

        }
        for(int j=0;j<=n-2;j++)
        {
            for(int i=0;i<=((n-1)-(j-1));i++)
            {
                if(j==0)
                {
                    d[i][j]=(y[i+1]-y[i])/(x[i+1]-x[i]);
                }
                else
                {
                    d[i][j]=(d[i+1][j-1]-d[i][j-1])/(x[i+j+1]-x[i]);
                }
            }
        }
        System.out.println("Divided Differance Table:");
        for(int i=1;i<=n-1;i++) {
            System.out.printf("Ꙟ%d\t\t\t\t\t\t", i);
        }
        System.out.println("\n");
        for(int i=0;i<=n-2;i++)
        {

            for(int j=0;j<=n-2-i;j++)
            {

                System.out.print(d[i][j]);
                System.out.print("\t\t\t\t\t");
            }
            System.out.println("\n");
        }

    }
}
