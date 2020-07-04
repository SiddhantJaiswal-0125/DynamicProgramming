/*
In this question You will have given a Array and you have to Count the
number of Subset whose Difference of the SUM of that subset if Equal to a
 given Number 'Diff.'
*/
import java.util.*;
public class SubsetWithGivenDifference
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Set");
        //Storing the size of the Set
        int n=sc.nextInt();
        System.out.println("Enter the Element of the SET");
        int arr[]=new int[n];
        //storing the element of the Set in an Array
        int range=0;
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
            range=range+arr[i];
        }
        System.out.println("Enter the Required Difference");
        int diff=sc.nextInt();

        /*
       * let s1 and s2 be the sum of the subset of the given set
       * Acorrding to Question :
       * s1+s2=range           (Eq-1)
       * s1-s2=Diff          (Eq-2)
       * Eq1+Eq2==>  S1=(range+diff)/2
        */
        int sum=(range+diff)/2;
        //Intializing the array
        int t[][]=new int[n+1][sum+1];
        //KEY step in Dynamic Programming
        for (int i=0;i<n+1;i++)
        {
            for (int j=0; j<sum+1;j++)
            {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                // inside this if statement we would choose whether we would take a
                // Number or not
                if(arr[i-1]<=j)
                    t[i][j]=t[i-1][j]+t[i-1][j-arr[i-1]];
                else
                    t[i][j]=t[i-1][j];
            }
        }

           if((range+diff)%2==0)
        System.out.println("Number of Subsets are : "+t[n][sum]);
           else
               System.out.println("Number of Subsets are : "+0);

    }
}
