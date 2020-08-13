import java.util.*;
public class QuickFindUnion
{
    int list[];
    int count;
    int n;
    QuickFindUnion(int nn)
    {
        n=nn;
        list=new int[n];
        for (int i=0;i<n;i++)
        {
            list[i]=i;
        }
        count=n;
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
    void union(int x, int y)
    {
        if(validate(x,y))
        {
            int xId=list[x];
            int yId=list[y];

            if (xId == yId)            
                return;

            for (int i=0;i<n;i++)
            {
                if (list[i]==xId)
                    list[i]=yId;
            }
            count--;
        }
    }
    boolean find(int x, int y)
    {
        if(validate(x,y)==true)
            return (list[x]==list[y]);
        else
            return false;
    }
    public static void main(String[] args)
    {
        QuickFindUnion q = new QuickFindUnion(3);
        q.union(0,1);
        System.out.println(q.find(1,0));
        System.out.println(q.find(0,2));
    }
}