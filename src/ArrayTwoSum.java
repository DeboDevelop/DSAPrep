import java.util.*;
public class ArrayTwoSum
{
  public static int[] compute(int arr[], int sum)
  {
    int ans[] = {-1, -1};
    Set<Integer> hset = new HashSet<Integer>();
    for(int i=0; i<arr.length; i++)
    {
      int x = sum-arr[i];
      if(hset.contains(x)==true)
      {
        ans[0] = x;
        ans[1] = arr[i];
        return ans;
      }
      hset.add(arr[i]);
    }
    return ans;
  }
  public static void main(String args[])
  {
    int arr[] = {0,2,4,6,10};
    int sum = 8;
    int result[] = new int[2];
    result = compute(arr, sum);
    System.out.println(result[0]+","+result[1]);
  }
}
