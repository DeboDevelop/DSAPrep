import java.util.*;
import java.io.*;
import java.lang.*;
public class WeightGraph
{
    class Edgenode implements Comparable<Edgenode> 
    {
        int weight,src,des;

        public int compareTo(Edgenode e)
        {
            return (this.weight-e.weight);
        }
    }
    int V,E;
    Edgenode edge[];
    WeightGraph(int v, int e)
    {
        V=v;
        E=e;
        edge = new Edgenode[E];
        for (int i=0;i<E;i++)
        {
            edge[i]= new Edgenode();
        }
    }
    void Kruskal()
    {
        Edgenode result[]=new Edgenode[V];
        int e=0;
        int i=0;
        for (i=0;i<V;i++)
        {
            result[i]= new Edgenode();
        }
        Arrays.sort(edge);

        WeightedQuickUnion qu=new WeightedQuickUnion(V);
        i=0;
        while(e<V-1)
        {
            Edgenode next = new Edgenode();
            next=edge[i++];

            if(qu.Connected(next.src, next.des)==false)
            {
                result[e++] = next;
                qu.union(next.src, next.des);
            }
        }
        System.out.println("Following are the edges in the constructed MST"); 
        for (i = 0; i < e; ++i) 
            System.out.println(result[i].src+" -- " + result[i].des+" == " + result[i].weight); 
    }
    public static void main(String[] args)
    {
        WeightGraph wg=new WeightGraph(4,5);

        wg.edge[0].src = 0; 
        wg.edge[0].des = 1; 
        wg.edge[0].weight = 10; 
  
        // add edge 0-2 
        wg.edge[1].src = 0; 
        wg.edge[1].des = 2; 
        wg.edge[1].weight = 6; 
  
        // add edge 0-3 
        wg.edge[2].src = 0; 
        wg.edge[2].des = 3; 
        wg.edge[2].weight = 5; 
  
        // add edge 1-3 
        wg.edge[3].src = 1; 
        wg.edge[3].des = 3; 
        wg.edge[3].weight = 15; 
  
        // add edge 2-3 
        wg.edge[4].src = 2; 
        wg.edge[4].des = 3; 
        wg.edge[4].weight = 4; 
  
        wg.Kruskal(); 
    }
}
