import java.util.*;
public class Duplicates
{
  public static boolean find_duplicates(int arr[])
  {
    Set<Integer> hset = new HashSet<Integer>();
    for(int i=0; i<arr.length; i++)
    {
      if(hset.contains(arr[i]) == true)
        return true;
      hset.add(arr[i]);
    }
    return false;
  }
  public static void main(String args[])
  {
    int arr[] = {1,2,6,4,2};
    boolean res = find_duplicates(arr);
    System.out.println(res);
  }
}
