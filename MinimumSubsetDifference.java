//This is extension of Subset sum problem with lots of new Knowledge
//You have to find the Minimun difference of two subset in a given set

import java.util.*;
public class MinimumSubsetDifference
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Set");
        //Storing the size of the Set
        int n=sc.nextInt();
        System.out.println("Enter the Element of Array");
        int arr[]=new int[n];
        //storing the element of the Set in an Array
        int range=0;
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
            //for getting the range of the Subset SUMS
            range=range+arr[i];
        }
        //Creating a Boolean Array which will  say that the SET has the provided Number,
        // Subset Sum or Not?
        boolean [][]t=new boolean[n+1][range+1];
        for (int i=0;i<n+1;i++)
        {
            //intializing the  2d array with true and false at i==0 and j==0
            for (int j=0;j<range+1;j++)
            {
             if(i==0)
                 t[i][j]=false;
             if(j==0)
                 t[i][j]=true;
            }
        }

        //Filling the array as per Choice Diagram
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<range+1;j++)
            {
                if(arr[i-1]<=j)
                    t[i][j]=t[i-1][j-arr[i-1]]||t[i-1][j];
                else
                    t[i][j]=t[i-1][j];
            }
        }
        //Now Finding the Minimum
        for(int i=(range/2);i>=0;i--)
        {
            if(t[n][i])
            {
                System.out.println((range-(2*i)));
                break;
            }
        }
    }
}
