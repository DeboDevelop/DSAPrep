import java.util.*;
public class BSTValidate
{
  public boolean validate(Node t)
  {
    if(t == null)
      return true;
    if(t.left != null)
    {
      if(t.left.data > t.data)
        return false;
    }
    if(t.right != null)
    {
      if(t.right.data < t.data)
        return false;
    }
    return (validate(t.left) && validate(t.right));
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
    BSTValidate b = new BSTValidate();
    System.out.println(b.validate(root));
  }
}
