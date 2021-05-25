import java.util.*;
public class Knapsack
{
  public static int compute(int capacity, int wt[], int vl[])
  {
     int t[][] = new int[wt.length+1][capacity+1];
     for(int i=0; i<wt.length+1; i++)
     {
      t[i][0]=0;
     }
     for(int i=0; i<capacity+1; i++)
     {
      t[0][i]=0;
     }
    for(int i=1; i<wt.length+1; i++)
     {
       for(int j=1; j<capacity+1; j++)
       {
         if(wt[i-1]>j)
         {
          t[i][j]=t[i-1][j];
         }
         else
         {
          t[i][j] = Math.max(t[i-1][j],t[i-1][j-wt[i-1]]+vl[i-1]);
         }
       }
     }
     return t[wt.length][capacity];
  }
  public static void main(String args[])
  {
    int wt[] = {5,20,4};
    int vl[] = {15,60,16};
    int capacity = 21;
    System.out.println(compute(capacity, wt, vl));
  }
}
