import java.util.*;
//PROBLEM STATEMENT: Given an Array of integers and a Number N
//You've to just say that (True/False) is their any Subset present
// whose Sum is equal to that given number N
//their is bit variation in the Code of Knapsack for this Problem(initialization)

public class SubsetSum
{
    public static void main(String[] args)
    {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the Size of Array");
    int n=sc.nextInt();
    System.out.println("Enter the Element of Array");
    int arr[]=new int[n];
    for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

    System.out.println("Enter the Required Sum");
    int sum=sc.nextInt();
    boolean t[][]=new boolean[n+1][sum+1];
    //initialization of boolean Matrix
    for(int i=0;i<n+1;i++)
    {
        for(int j=0;j<sum+1;j++)
        {
            if(i==0)
                t[i][j]=false;
            if(j==0)
                t[i][j]=true;

        }
    }

  //Further Dp code
    for(int i=1;i<n+1;i++)
    {
        for(int j=1;j<sum+1;j++)
        {
            if(arr[i-1]<=j)
                t[i][j]=t[i-1][j-arr[i-1]]||t[i-1][j];
           else
               t[i][j]=t[i-1][j];
        }
    }
    System.out.println(t[n][sum]);

    }
}
