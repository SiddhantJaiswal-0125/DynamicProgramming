/*
* Coin Change problem has 2 Diff. Kind of problems itself
* this one is part1  ,Problem Statement:
* Given a array of Different Coins which has unlimited Supply and a  Required Sum:
* you have to find the Number of Ways in which it can done !
*/

import java.util.Scanner;
public class CoinChangeProblemP1
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
        int t[][]=new int[n+1][sum+1];
        //In DP ,always have a look in initialization because it is the most important Step!
        //INITIALIZATION
        for (int i=0;i<n+1;i++)
            for (int j=0;j<sum+1;j++)
            {
                if(i==0)
                    t[i][j]=0;
                if(j==0)
                    t[i][j]=1;
            }

        for (int i=1;i<n+1;i++)
        {
            for (int j=1;j<sum+1;j++)
            {
                if(arr[i-1]<=j)
                    t[i][j]=t[i-1][j]+t[i][j-arr[i-1]];
                //No MAX-MIN because  we have to Count not to maximize or minimize;
                else
                    t[i][j]=t[i-1][j];
            }
        }

        System.out.println("Number of Ways  "+t[n][sum]);

    }
}
