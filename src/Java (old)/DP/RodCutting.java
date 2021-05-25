public class RodCutting
{
    public static int cut(int arr[]) {
        int t[] = new int[arr.length+1];

        t[0]=0;

        int max;

        for (int i=1;i<=arr.length;i++) {
            max=Integer.MIN_VALUE;
            for (int j=0;j<i;j++) {
                max = Math.max(max, arr[i-j-1] + t[j]);
            }
            t[i]=max;
            System.out.println(i+" | "+t[i]);
        }
        
        return t[arr.length];
    }
    public static void main(String[] args) {
        int profit[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Profit - "+cut(profit));
    }
}