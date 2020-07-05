/*
* It has the Most Variations of Question Minimum 15Types
*Problem_Statement: Given two string x and y;
* you have to count Longest Common Subsequence  in the both of the Sequence
*/
import  java.util.*;
public class LongestCommonSubsequenceRecursive
{
    public static int  t[][];
    public static int LCS(String x,String y,int n,int m)
    {
        if(n==0||m==0)
            return 0;
        if(t[n][m]!=-1)
            return t[n][m];
        if(x.charAt(n-1)==y.charAt(n-1))
            return t[n][m] =1+LCS(x,y,n-1,m-1);
        else
            t[n][m]=max(LCS(x,y,n-1,m),LCS(x,y,n,m-1));

    return t[n][m];
    }
    public static int max(int a,int b)
    {return a>b?a:b;}
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String x=sc.nextLine();
        String y=sc.nextLine();
        int n=x.length();
        int m=y.length();
        t=new int[n+1][m+1];
        for (int i=0;i<n+1;i++)
            for (int j=0;j<m+1;j++)
                t[i][j]=-1;

        System.out.println("Longest Common Subsequence is of length"+LCS(x,y,n,m));
    }
}
