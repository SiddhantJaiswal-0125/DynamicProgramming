//This code is by recursion
import java.util.*;
/*
* 0-1 KnapSack is the parent of 6 different Question
* */

public class KnapSack01
{
    //this array is for memoization
    public static int t[][];

    public static int Knapsack(int wt[],int val[],int w,int n)
    {
        if(n==0||w==0)   //Base_Condition
            return 0;

        //Choice Diagram
        if(t[n][w]!=-1)
            return t[n][w];

        if(wt[n-1]<=w)
            return t[n][w]=max(val[n-1]+Knapsack(wt,val,w-wt[n-1],n-1),Knapsack(wt,val,w,n-1));
            //get Maximum between them
        else if(wt[n-1]>w)
            return t[n][w]=Knapsack(wt,val,w,n-1);

        return t[n][w];
    }
    public static int max(int a,int b)
    {return a>b?a:b; }
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
     t=new int[n+1][w+1];
     for (int i=0;i<n+1;i++)
         for (int j=0;j<w+1;j++)
         {  t[i][j]=-1;}


     int ans=Knapsack(wt,val,w,n);
     System.out.println("The Maximum Profit Will be " +ans);
    }
}
