import java.util.*;
public class TreeSum
{
  public void find_sum(int sum, Node t)
  {
     if (t == null)
      return;
     sum=sum+t.data;
     if(t.left == null && t.right == null)
     {
         System.out.println(sum);
         return;
     }
     if(t.left != null) {
       find_sum(sum, t.left);
     }
     if (t.right != null) {
       find_sum(sum, t.right);
     }
  } 
  public static void main(String args[])
  {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    root.left.right.left = new Node(10);
    root.right = new Node(3);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    TreeSum t = new TreeSum();
    t.find_sum(0,root);
  }
}
