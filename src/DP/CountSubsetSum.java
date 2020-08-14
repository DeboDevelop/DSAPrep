public class CountSubsetSum
{
    public static int subsetsum(int arr[], int sum)
    {
        int t[][] = new int[arr.length+1][sum+1];
        int i, j;
        for (i=0;i<arr.length+1;i++)
            t[i][0] = 1;
        for (j=1;j<sum+1;j++)
            t[0][j] = 0;
        
        for (i=1;i<arr.length+1;i++) {
            for (j=1;j<sum+1;j++) {
                if( arr[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
            }
        }
        return t[arr.length][sum];
    }
    public static void main(String[] args) {
        int arr[] = {3, 3, 3, 3};
        int sum = 6;
        System.out.println(subsetsum(arr, sum));
    }
}