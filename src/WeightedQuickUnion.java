import java.util.*;
public class WeightedQuickUnion
{
    int n;
    int count;
    int parent[];
    int size[];
    WeightedQuickUnion(int nn)
    {
        n=nn;
        count=n;
        parent=new int[n];
        size=new int[n];
        for (int i=0;i<n;i++)
        {
            parent[i]=i;
            size[i]=1;
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
    boolean Connected(int x, int y)
    {
        if (validate(x,y))
        {
            return (find(x)==find(y));
        }
        else
            return false;
    }
    void union(int x, int y)
    {
        if (validate(x,y))
        {
            int rootX=find(x);
            int rootY=find(y);

            if(size[rootX]<size[rootY])
            {
                parent[rootX]=rootY;
                size[rootY]+=size[rootX];
            }
            else
            {
                parent[rootY]=rootX;
                size[rootX]+=size[rootY];
            }
            count--;
        }
    }
    public static void main(String[] args)
    {
        WeightedQuickUnion q = new WeightedQuickUnion(3);
        q.union(0,1);
        System.out.println(q.Connected(1,0));
        System.out.println(q.Connected(0,2));
    }
}