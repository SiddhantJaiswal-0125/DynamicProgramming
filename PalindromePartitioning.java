/*
* Given a String ,You have find out Minimum # of Partioning Such that
* each substring is Palindrome
* e.g: NITIK  O/p: 2  (N |  ITI  | K)
 */


import java.util.Scanner;

public class PalindromePartitioning
{
    public static int t[][];

    public static  boolean isPalindrome(String s,int i,int j)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return  true;
    }

    public static  int solve(String s,int i,int j)
    {
        if (i>=j)
            return 0;
        if (isPalindrome(s,i,j))
            return  0;
        int min=Integer.MAX_VALUE;
        for (int k=i;k<=j-1;k++)
        {
            if (t[i][k]==-1)
               t[i][k]= solve(s,i,k);
            if (t[k+1][j]==-1)
                t[k+1][j]=solve(s,k+1,j);
            int temp=t[i][k]+t[k+1][j]+1;
            if(temp<min)
                min=temp;
        }
        return  t[i][j]=min;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println( "Enter a String :");
        String s=sc.nextLine();
        int n=s.length();
        t=new int[n+1][n+1];
        for (int p=0;p<n+1;p++)
            for (int q=0;q<n+1;q++)
                t[p][q]=-1;
            int ans=solve(s,0,n-1);
        System.out.println(ans);
    }
}
