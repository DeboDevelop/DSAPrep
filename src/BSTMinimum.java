import java.util.Arrays;
public class BSTMinimum
{
    public Node createBST(int arr[], int start, int end)
    {
        if (start > end) {
            return null;
        }

        int mid = (start+end)/2;
        Node root =new Node(arr[mid]);
        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }
    public void preOrder(Node node)
    {
        if(node == null)
            return;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void main(String[] args) {
        BSTMinimum b = new BSTMinimum();
        int arr[] = {3, 5, 1, 2, 7, 4, 6};
        Arrays.sort(arr);
        int n = arr.length;
        Node root = b.createBST(arr, 0, n-1);
        b.preOrder(root);
        System.out.println();
    }
}