public class SubsetDiff
{
    public static int subsetsum(int arr[])
    {
        int sum=0;

        for (int i=0;i<arr.length;i++)
            sum+=arr[i];

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
        
        int diff=Integer.MAX_VALUE;
        for (j=sum/2; j>=0; j--) 
        { 
            if (t[arr.length][j] == true) 
            { 
                diff = sum-2*j; 
                break; 
            } 
        } 
        return diff; 
    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 8};
        System.out.println(subsetsum(arr));
    }
}