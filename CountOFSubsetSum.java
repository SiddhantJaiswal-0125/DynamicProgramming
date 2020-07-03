/*
PROBLEM_STATEMENT:
Find Out the Number of Subset Present Whose Sum is equal to a Given number N
*/
/*
LOGIC: In the Initialization part Instead of False use 0 and for true Use 1
and Count the Number of subset present means instead of || just add(+) them;
*/

import java.util.Scanner;
public class CountOFSubsetSum
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

        int [][]t=new int[n+1][sum+1];


        //INITIALIZATION
        for(int i=0;i<n+1;i++)
            for(int j=0;j<sum+1;j++)
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
                    t[i][j]=t[i-1][j]+t[i-1][j-arr[i-1]];
                else
                    t[i][j]=t[i-1][j];
            }
        }

        System.out.println(t[n][sum]);

    }
}
