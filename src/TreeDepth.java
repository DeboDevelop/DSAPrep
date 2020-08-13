import java.util.*;
public class TreeDepth
{
  int find_depth(int depth, Node t)
  {
       if(t == null)
       {
           return depth;
       }
       int leftDepth = find_depth(depth+1, t.left)-1;
       int rightDepth = find_depth(depth+1, t.right)-1;
       return (leftDepth+rightDepth);
  }
  public static void main(String args[])
  {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    root.right = new Node(3);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    TreeDepth t = new TreeDepth();
    System.out.println(t.find_depth(0,root));
  }
}
