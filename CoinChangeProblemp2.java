/*
 * Coin Change problem has 2 Diff. Kind of problems itself
 * this one is part2  ,Problem Statement:
 * Given a array of Different Coins which has unlimited Supply and a  Required Sum:
 * you have to find the Minimum Number of Coins by which it can done !
 */

//THIS QUESTION HAS A  TWIST IN INITIALIZATION!!
import java.util.Scanner;
public class CoinChangeProblemp2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Set");
        //Storing the size of the Set
        int n=sc.nextInt();
        System.out.println("Enter the Different Types  of Coins");
        int arr[]=new int[n];
        //storing the element of the Set in an Array
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Enter the Required Sum");
        int sum=sc.nextInt();
       //INITIALIZATION
       //has a TWIST as compare to rest
       int t[][]=new int[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            for (int j=0;j<sum+1;j++)
            {
                if(i==0)
                    t[i][j]=0;
                if(j==0)
                    t[i][j]=Integer.MAX_VALUE-1;
                 if(j>0)
                 {
                     if(j%arr[0]==0)
                         t[1][j]=j/arr[0];
                     else
                         t[1][j]=Integer.MAX_VALUE-1;
                 }
            }
        }

        for(int i=2;i<n+1;i++)
            for (int j=2;j<sum+1;j++)
            {
                if (arr[i-1]<=j)
                    t[i][j]=min(1+t[i][j-arr[i-1]],t[i-1][j]);
                else
                    t[i][j]=t[i-1][j];
            }

        System.out.println("Minimum Number of coins "+t[n][sum]);

    }
    public static  int min(int a,int b)
    {return a<b?a:b;}
}
