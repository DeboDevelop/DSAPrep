import java.util.*;
public class CoinChangeMin
{
    public static int way(int coin[], int sum)
    {
        int t[] = new int[sum+1];
        Arrays.fill(t, Integer.MAX_VALUE);

        t[0]=1;

        for (int i=1;i<=sum;i++) {
            for (int j=0;j<coin.length;j++) {
                if(coin[j]<=i) {
                    int res = t[i - coin[j]]; 
                if(res != Integer.MAX_VALUE && res + 1 < t[i]) 
                       t[i] = res + 1; 
                }
            }
        }

        return t[sum];
    }
    public static void main(String[] args) {
        int coin[] = {1, 8, 20};
        int sum = 24;
        System.out.println(way(coin, sum));
    }
}