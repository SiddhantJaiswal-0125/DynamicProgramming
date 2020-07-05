/*
* KnapSack is of 3 Types :
* 1. Fractional knapack (Greedy)
* 2.  0 1 KnapSack (DP)
* 3.  Unbounded KnapSack (DP)
      - in this type ,Their No restriction on Occurence (==> Multiple Occerence is Allowed)
 */

import java.util.Scanner;
public class UnboundedKnapSack
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Set");
        //Storing the size of the Set
        int n=sc.nextInt();
        System.out.println("Enter the types of element ");
        int arr[]=new int[n];
        int val[]=new int[n];
        //storing the element of the Set in an Array
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        System.out.println("Enter the value as per the above entered Elements:" );
        for(int i=0;i<n;i++)
            val[i] = sc.nextInt();


        System.out.println("Enter the Required Sum: ");
        int sum=sc.nextInt();
        //Intializing the array
        int t[][]=new int[n+1][sum+1];
        //KEY step in Dynamic Programming
        for (int i=0;i<n+1;i++)
            for (int j=0; j<sum+1;j++)
                if (i == 0||j==0)
                    t[i][j] = 0;

        for(int i=1;i<n+1;i++)
            for(int j=1;j<sum+1;j++)
            {
                //the Main step in inside if statement
                /*
                * let us consider a array  | 1 | 2 | 3 | 4 |
                * so in recursive tree of (0 1 Knapsack) if we have Processed last
                * element of Array the further it will call for n-1
                * but in unbounded Knapsack as their is No restriction in Multiple Occurence
                * we will call for  n again .
                * n is replaced by i and weight is replaced by j
                * */
                if(arr[i-1]<=j)
                    t[i][j]=max(val[i-1]+t[i][j-arr[i-1]],t[i-1][j]);
                else
                    t[i][j]=t[i-1][j];
            }
        System.out.println(t[n][sum]);
    }
    public static int max(int a,int b)
    {return a>b?a:b; }
}
