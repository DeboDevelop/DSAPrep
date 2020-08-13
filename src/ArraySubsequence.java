import java.util.*;
public class ArraySubsequence
{
  public static boolean compute(int arr1[], int arr2[])
  {
    Deque<Integer> stack = new ArrayDeque<Integer>();
    for(int i=0; i<arr2.length; i++)
    {
      stack.push(arr2[i]);
    }
    for(int i=arr1.length-1; i>=0; i--)
    {
        try {
            if(stack.peek() == arr1[i])
             {
              stack.pop();
             }
        } catch(Exception e) {
            
        }
    }
    if(stack.size() == 0)
      return true;
    else
      return false;
  }
  public static void main(String args[])
  {
    int arr1[] = {100, 200, 1, 900, 800, 2};
    int arr2[] = {1, 2};
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
