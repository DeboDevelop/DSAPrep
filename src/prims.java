import java.util.*;
import java.lang.*; 
import java.io.*; 

public class prims
{
    int V;
    int graph[][];
    prims(int v, int g[][])
    {
        V=v;
        graph=g;
    }
    int minKey(int key[], Boolean mstSet[])
    {
        int min=Integer.MAX_VALUE, min_index=-1;

        for (int i=0;i<V;i++)
        {
            if(key[i]<min && mstSet[i]==false)
            {
                min=key[i];
                min_index=i;
            }
        }

        return min_index;
    }
    void printMST(int parent[]) 
    { 
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < V; i++) 
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]); 
    } 
    void primsMST()
    {
        int parent[]=new int[V];

        int key[]=new int[V];

        Boolean mstSet[] = new Boolean[V];

        for (int i=0;i<V;i++)
        {
            key[i]=Integer.MAX_VALUE;
            mstSet[i]=false;
        }

        key[0]=0;
        parent[0]=-1;

        for (int i=0;i<V-1;i++)
        {
            int u=minKey(key, mstSet);

            mstSet[u]=true;

            // Update key value and parent index of the adjacent 
            // vertices of the picked vertex. Consider only those 
            // vertices which are not yet included in MST 
            for (int v = 0; v < V; v++) 
  
                // graph[u][v] is non zero only for adjacent vertices of m 
                // mstSet[v] is false for vertices not yet included in MST 
                // Update the key only if graph[u][v] is smaller than key[v] 
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) { 
                    parent[v] = u; 
                    key[v] = graph[u][v]; 
                } 
        }
        printMST(parent);
    }

    public static void main(String[] args)
    {
        int g[][] = new int[][] { { 0, 2, 0, 6, 0 }, 
                                  { 2, 0, 3, 8, 5 }, 
                                  { 0, 3, 0, 0, 7 }, 
                                  { 6, 8, 0, 0, 9 }, 
                                  { 0, 5, 7, 9, 0 } };

        prims p =new prims(5, g);
        p.primsMST();
    }
}