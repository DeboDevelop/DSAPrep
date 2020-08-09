import java.util.*;
class Node
{
  int data; Node left,right;
  Node(int v)
  {
    data=v;
    left = right = null;
  }
}
public class tree 
{
  public boolean search(Node n, int key)
  {
    if(n == null)
      return false;
    if(n.data == key)
      return true;
    return (n.data < key) ? (search(n.right, key)) : (search(n.left, key));
  }
  public void print_data(Node n)
  {
    if(n == null)
      return;
    // Post order traversal
    print_data(n.left);
    System.out.println(n.data);
    print_data(n.right);
  }

  // DFS
  public void DFS(Node n)
  {
    if(n == null)
      return;
    System.out.println(n.data);
    DFS(n.left);
    DFS(n.right);
  }

  public static void main(String args[])
  {
    Node root = new Node(15);
    root.left = new Node(10);
    root.right = new Node(30);
    root.left.left = new Node(9);
    root.left.right = new Node(11);
    tree t= new tree();
    t.DFS(root);
  }
}
