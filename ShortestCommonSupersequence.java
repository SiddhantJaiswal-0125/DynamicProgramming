/*
* SuperSequence of A and b is Nothing but A String which has both  A and B
* e.g: A:geek and B:eke
* ans: geekeke,geeke ,etc.
* In this question we Have to Print the Length of Shortest Common Supersequence
*/

import java.util.Scanner;
public class ShortestCommonSupersequence
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Two Stirng :");
        String x=sc.nextLine(); //String 1
        String y=sc.nextLine();  //String 2
        int m=x.length();
        int n=y.length();
        int [][]t=new int[m+1][n+1];
        for (int i=0;i<m+1;i++)
            for (int j=0;j<n+1;j++)
                t[i][j]=0;

        for(int i=1;i<m+1;i++)
            for (int j=1;j<n+1;j++)
            {
                if(x.charAt(i-1)==y.charAt(j-1))
                    t[i][j]=1+t[i-1][j-1];
                else
                    t[i][j]=max(t[i-1][j],t[i][j-1]);
            }
        //Main Step
        //in the worst Case we can have supersequence of length m+n but as we know About LCS
        //so we can erase the lcs in one string as that characters already present in the another string
        int l=m+n-t[m][n];
        System.out.println("Shortest Common SuperSequence :"+l);
    }
    public static int max(int a,int b)
    {return a>b?a:b;}
}
