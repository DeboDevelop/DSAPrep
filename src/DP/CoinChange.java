import java.util.*;
public class CoinChange
{
    public static int way(int arr[], int sum)
    {
        int t[] = new int[sum+1];
        Arrays.fill(t, 0);

        t[0]=1;

        for (int i=0;i<arr.length;i++) {
            for (int j=arr[i];j<=sum;j++) {
                t[j] += t[j-arr[i]];
            }
        }

        return t[sum];
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int sum = 4;
        System.out.println(way(arr, sum));
    }
}