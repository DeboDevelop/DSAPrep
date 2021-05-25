import java.util.*;
public class BSTClosest
{
  public int find_closest(int num, Node t)
  {
    if( t == null)
      return Integer.MAX_VALUE;
    int abs_diff = Math.abs(t.data - num);
    int other = t.data < num ? find_closest(num, t.right) : find_closest(num, t.left);
    return Math.min(abs_diff, other);
  }
  public boolean search(Node n, int key)
  {
    if(n == null)
      return false;
    if(n.data == key)
      return true;
    return (n.data < key) ? (search(n.right, key)) : (search(n.left, key));
  }
  public static void main(String args[])
  {
    Node root = new Node(9);
    root.left = new Node(4);
    root.left.left = new Node(3);
    root.left.right = new Node(6);
    root.left.right.left = new Node(5);
    root.left.right.right = new Node(7);
    root.right = new Node(17);
    root.right.right = new Node(22);
    root.right.right.left = new Node(20);
    BSTClosest b = new BSTClosest();
    int diff = b.find_closest(18, root);
    if(b.search(root,18+diff)==true)
      System.out.println(18+diff);
    if(b.search(root,18-diff)==true)
      System.out.println(18+diff);
  }
}
