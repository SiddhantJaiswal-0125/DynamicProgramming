/*
* I/P: A string of COmbination (T,F,|,&,^)
* O/P: Number of way of Insertion of Parenthesis such that final answer will be true:
* e.g
* i/p: T^F&T
* way1:( T^(F&T))
* way2:((T^F)&T)
*/


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Evaluate_Parenthesization
{
   static int t[][][];
    public static  int solve(String s,int i,int j,boolean istrue)
    {
        if (i>j)
            return  0;
        if(i==j)
            {
                if(istrue)
                    return s.charAt(i)=='T'?1:0;
                else
                    return s.charAt(i)=='F'?1:0;
            }
            int ans=0;
            String temp=i+" "+j+" "+istrue;
            int m=0;
            if (istrue)
                m=1;
            if (t[i][j][m]!=-1)
                return  t[i][j][m];

            for (int k=i+1;k<=j-1;k=k+2)
            {
                int lt=solve(s,i,k-1,true);
                int lf=solve(s,i,k-1,false);
                int rt=solve(s,k+1,j,true);
                int rf=solve(s,k+1,j,false);
                if (s.charAt(k)=='&')
                    ans=ans+lt*rt;
                else if (s.charAt(k)=='|')
                    ans=ans+lt*rt+rt*lf+rf*lt;
                else if (s.charAt(k)=='^')
                    ans=ans+lf*rt+rf*lt;
            }
            return t[i][j][m]=ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Combination: ");
        String s=sc.nextLine();
        t=new int [s.length()][s.length()][2];
        for (int i=0;i<s.length();i++)
            for (int j=0;j<s.length();j++)
                for (int k=0;k<2;k++)
                    t[i][j][k]=-1;
                int ans=solve(s,0,s.length()-1,true);
        System.out.println(ans);


    }
}
