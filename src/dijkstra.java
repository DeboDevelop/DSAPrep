import java.util.*;
import java.lang.*; 
import java.io.*; 

public class dijkstra
{
    int V;
    int graph[][];
    dijkstra(int v, int g[][])
    {
        V=v;
        graph=g;
    }
    int minDistance(int dist[], Boolean shtset[])
    {
        int min=Integer.MAX_VALUE, min_index=-1;

        for (int i=0;i<V;i++)
        {
            if(dist[i]<=min && shtset[i]==false)
            {
                min=dist[i];
                min_index=i;
            }
        }

        return min_index;
    }
    void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i=0;i<V;i++)
        {
            System.out.println(i+"\t\t"+dist[i]);
        }
    }
    void dijkstraSPT(int src)
    {
        int dist[]=new int[V];

        Boolean shtSet[]=new Boolean[V];

        for (int i=0;i<V;i++)
        {
            dist[i]=Integer.MAX_VALUE;
            shtSet[i]=false;
        }
        dist[src]=0;
        // Find shortest path for all vertices 
        for (int count = 0; count < V - 1; count++)
        { 
            // Pick the minimum distance vertex from the set of vertices 
            // not yet processed. u is always equal to src in first 
            // iteration. 
            int u = minDistance(dist, shtSet); 
  
            // Mark the picked vertex as processed 
            shtSet[u] = true; 
  
            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v = 0; v < V; v++) 
  
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!shtSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        }
        printSolution(dist);
    }
    public static void main(String[] args) 
    { 
        int g[][] = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        dijkstra d=new dijkstra(9, g);
        d.dijkstraSPT(0);
    }
}