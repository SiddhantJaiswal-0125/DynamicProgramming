/*
* you will have been given Two String 'a' and 'b' and you have to Return Wether
* String 'a' is SubSequence of B or Not (TRUE /FALSE);
* e.g: A:axy ,B:adxcpy   ==>return True
* */

import java.util.Scanner;

public class SequencePatternMatching
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String A:");
        String a=sc.nextLine();
        System.out.println("Enter String B:");
        String b=sc.nextLine();
        int m=a.length();
        int n=b.length();
        int t[][]=new int[m+1][n+1];
        for (int i=0;i<m+1;i++)
            for (int j=0;j<n+1;j++)
                if (i==0||j==0)
                    t[i][j]=0;
        for (int i=1;i<m+1;i++)
            for (int j=1;j<n+1;j++)
                if (a.charAt(i-1)==b.charAt(j-1))
                    t[i][j]=1+t[i-1][j-1];
                else
                    t[i][j]=max(t[i-1][j],t[i][j-1]);
        System.out.println(m==t[m][n]);


    }
    public static int max(int a,int b){
        return a>b?a:b;
    }
}
