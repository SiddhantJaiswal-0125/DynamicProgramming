/*
* One of Best among all the Part of DP;
* Uses lots of Thinking Ability:
* we will only Recursive+memoziation (NO TOP-DOWN);
* input: a String or an Array
* {
* you have to take 3 integer i and j and k
* }
*/


/*
* Given an Array of size N which has the Dimension of N-1 matrix
* Dimension of Matrix k(i)=A[i]*A[i-1];
* we have of fine the Minimum cost of Multiplication of the matrix
* */


//IF DONT know about cost of Multiplication go and Google it!!


import java.util.Scanner;
public class MatrixChainMultiplication
{
    public static int[][]t;

    public static int solve(int a[],int i,int j)
    {
        if (i>=j)
            return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++)
        {
            if (t[i][k]==-1)
                t[i][k]=solve(a, i,k);
            if(t[k+1][j]==-1)
                t[k+1][j]=solve(a,k+1,j);
            int temp=t[i][k]+t[k+1][j]+a[i-1]*a[k]*a[j];

            if (temp<min)
                min=temp;
        }
        return  t[i][j]=min;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Array:");
        int n=sc.nextInt();
        t=new int[n+1][n+1];
        int a[]=new int[n];
        for (int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int i=1;
        int j=n-1;
      for (int p=0;p<n;p++)
          for (int q=0;q<n;q++)
              t[p][q]=-1;


        int ans=solve(a,i,j);
        System.out.println(ans);
    }
}
