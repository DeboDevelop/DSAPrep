import java.util.*;
public class ArraySubsequence
{
  public static boolean compute(int arr1[], int arr2[])
  {
    //Set<Integer> hset = new HashSet<Integer>(Arrays.asList(arr1));
    Set<Integer> hset = new HashSet<Integer>();
    for(int i=0; i<arr1.length; i++)
    {
      hset.add(arr1[i]);
    }
    for(int i=0;i<arr2.length; i++)
    {
      if(hset.contains(arr2[i]) == false)
      {
        return false;
      }
    }
    return true;
  }
  public static void main(String args[])
  {
    int arr1[] = {11, 1, 13, 21, 3, 7};
    int arr2[] = {11, 3, 7, 1};
    boolean res = compute(arr1, arr2);
    if(res == true)
    {
      System.out.println("arr2[] is a subset of arr1[]");
    }
    else
    {
      System.out.println("arr2[] is not a subset of arr1[]");
    }
  }
}
