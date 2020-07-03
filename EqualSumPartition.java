/*
*PROBLEM_STATEMENT:
* Find is their any two subset whose Sums are Equal
 */
//LOGIC:If whole sum of Array is Even then divide the sum by 2 and use the Subsetsum technique
//else return False

import java.util.*;
public class EqualSumPartition
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Array");
        int n=sc.nextInt();
        int sum=0;
        System.out.println("Enter the Element of Array");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
            sum=sum+arr[i];
        }
        if(sum%2!=0)
            System.out.println("False");
        else
        {
            int k=(sum/2);
            boolean t[][]=new boolean[n+1][k+1];
            for(int i=0;i<n+1;i++)
                for (int j=0;j<k+1;j++)
                {
                   if(i==0)
                       t[i][j]=false;
                   if(j==0)
                       t[i][j]=true;
                }
            for (int i=1;i<n+1;i++)
                for(int j=1;j<k+1;j++)
                {
                    if (arr[i - 1]<=j)
                    {
                     t[i][j]=(t[i-1][j-arr[i-1]]||t[i-1][j]);
                    }
                    else
                        t[i][j]=t[i-1][j];
                }
            System.out.println(t[n][k]);
        }
    }
}
