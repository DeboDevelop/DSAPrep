import java.util.*;
public class QuickUnion
{
    int parent[];
    int n;
    int count;
    QuickUnion(int nn)
    {
        n=nn;
        parent=new int[n];
        count=n;
        for (int i=0;i<n;i++)
        {
            parent[i]=i;
        }
    }
    boolean validate(int x, int y)
    {
        if(x>=0 && x<n && y>=0 && y<n)
        {
            return true;
        }
        else
            throw new IllegalArgumentException("index " + x + " or " + y + " is not between 0 and " + (n-1));
    }
    int find(int x)
    {
        while(x != parent[x])
            x=parent[x];
        return x;
    }
    void union(int x, int y)
    {
        if (validate(x,y))
        {
            int rootX=find(x);
            int rootY=find(y);
            if(rootX==rootY)
                return;
            parent[rootX]=rootY;
            count--;
        }
    }
    boolean Connected(int x, int y)
    {
        if (validate(x,y))
        {
            return (find(x)==find(y));
        }
        else
            return false;
    }
    public static void main(String[] args)
    {
        QuickUnion q = new QuickUnion(3);
        q.union(0,1);
        System.out.println(q.Connected(1,0));
        System.out.println(q.Connected(0,2));
    }
}