public class SubsetSum
{
    public static boolean subsetsum(int arr[], int sum)
    {
        boolean t[][] = new boolean[arr.length+1][sum+1];
        int i, j;
        for (i=0;i<arr.length+1;i++)
            t[i][0] = true;
        for (j=1;j<sum+1;j++)
            t[0][j] = false;

        for (i=1;i<arr.length+1;i++) {
            for (j=0;j<sum+1;j++) {
                if( arr[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
            }
        }
        return t[arr.length][sum];
    }
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 8, 10};
        int sum = 19;
        System.out.println(subsetsum(arr, sum));
    }
}