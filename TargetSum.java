/*
* PROBLEM STATEMENT:
* This Question says that you have Given an array of integers and you have to USE ('+'/'-')
* either of these two Operators and Return the Number of Ways It can be Done.

* For Example:
* arr[]:1  1  2  3
* sum=1;
* way1: +1 -1 -2 +3
* way2: +1  +1 +2 -3
* way3:  -1 +1 -2 +3
*Total 3 ways to do this!
*/

import java.util.*;
public class TargetSum
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
        System.out.println("Enter the Required Sum");
        int diff=sc.nextInt();
/*
* if you Clearly observe this question then you will see it is nothing but
* the CountNumberOfSubsetDifference question and just 1 step ahead but the code will be Same
 */
        int sum=(range+diff)/2;
        if((range+diff)%2==0) {
            //Intializing the array
            int t[][] = new int[n + 1][sum + 1];
            //KEY step in Dynamic Programming
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < sum + 1; j++) {
                    if (i == 0)
                        t[i][j] = 0;
                    if (j == 0)
                        t[i][j] = 1;
                }
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < sum + 1; j++) {
                    // inside this if statement we would choose whether we would take a
                    // Number or not
                    if (arr[i - 1] <= j)
                        t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                    else
                        t[i][j] = t[i - 1][j];
                }
            }


            System.out.println("Number of Subsets are : " + t[n][sum]);
        }
        else
            System.out.println("Number of Subsets are : "+0);




    }
}
