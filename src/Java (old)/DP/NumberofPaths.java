import java.io.*;
import java.util.*;

class Solution {

  static int numOfPathsToDest(int n) {
    int arr[][]=new int[n][n];
    for (int i=0;i<n;i++) {
      for(int j=0;j<n;j++) {
        arr[i][j]=0;
      }
    }
    for(int i=0;i<n;i++) {
      arr[n-1][i]=1;
    }
    for(int i=n-2;i>=0;i--) {
      for(int j=1;j<n;j++) {
        if((i+j)>=n-1)
          arr[i][j]=arr[i][j-1]+arr[i+1][j];
      }
    }
    return arr[0][n-1];
  }

  public static void main(String[] args) {
    System.out.println(numOfPathsToDest(4));
  }

}

