/*
* In this you have to Find the Length of LongestRepeatingSubsequence:
* i.e for example Str: AABEBCDD
* repeating Subsequence:  a) ab,ab
*                         b) abd ,abd
*                         c) etc!
* but you have to Print the length of the Longest
*/


import java.util.Scanner;
public class LongestRepeatingSubsequence
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String :");
        String a=sc.nextLine();
        String b=new String(a);
        int m=a.length();
        int n=m;
        int t[][]=new int[m+1][n+1];
        for (int i=0;i<m+1;i++)
            for (int j=0;j<n+1;j++)
                if (i==0||j==0)
                    t[i][j]=0;
        for (int i=1;i<m+1;i++)
            for (int j=1;j<n+1;j++)
                if (a.charAt(i-1)==b.charAt(j-1)&&i!=j)
                    t[i][j]=1+t[i-1][j-1];
                else
                    t[i][j]=max(t[i-1][j],t[i][j-1]);


        System.out.println("Longest Repeating Subsequence is of Length "+t[m][n]);



    }
    public static int max(int a,int b)
    {return a>b?a:b;}
}
