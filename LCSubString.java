/*
*Their is difference between substring and Subsequence
* S1=abcde and S2=abfce
* LCsubsequence is ABCE
* but LCsubstring is AB
*/

import java.util.Scanner;
public class LCSubString
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
               if(i==0||j==0)
                t[i][j]=0;

               int max=0;
        for (int i=1;i<m+1;i++)
            for (int j=1;j<n+1;j++)
            {
               if (x.charAt(i-1)==y.charAt(j-1))
               {
                   t[i][j] = 1 + t[i - 1][j - 1];

               if(t[i][j]>max)//Now Storing Maximum length among all
                   max=t[i][j];
               }else
                   t[i][j]=0;//Because the length of the substring will become 0
                // As the character doesnot match with the Char of next string so the Substring will break
            }
        System.out.println("Length of Max Substring is : "+max);

    }
}
