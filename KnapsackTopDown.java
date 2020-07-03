import java.util.*;
//Just understand the code dont just memorize the code it will not help you
//It is the actual Dynamic_Programming
//Dynamic_Programming is actually Enhanced Recursion
public class KnapsackTopDown
{

    public static void main(String[] args)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Size of Array");
            int n=sc.nextInt();
            System.out.println("Enter the weight  of the Items");
            int wt[]=new int[n];
            int val[]=new int[n];
            for (int i=0;i<n;i++)
                wt[i]=sc.nextInt();
            System.out.println("Enter the Value  of the Items");
            for (int i=0;i<n;i++)
                val[i]=sc.nextInt();

            System.out.println("Enter the Wight of the Knapsack");
            int w=sc.nextInt();

            //initializing an 2-d array for storing value
            int [][]t=new int[n+1][w+1];
            for (int i=0;i<n+1;i++)
                for (int j=0;j<w+1;j++)
                    if(i==0||j==0)
                        t[i][j]=0;
            for(int i=1;i<n+1;i++)
                for (int j=1;j<w+1;j++)
                {
                    if(wt[i-1]<=j)
                    {
                        t[i][j]=max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                    }
                    else
                        t[i][j]=t[i-1][j];
                }

            System.out.println("The Maximum Profit Will be "+t[n][w]);
        }
    public static int max(int  a,int b)
    {return  a>b?a:b;}


}
