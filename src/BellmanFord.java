public class BellmanFord
{
    class Edgenode
    {
        int weight,src,des;
    }
    int V,E;
    Edgenode edge[];
    BellmanFord(int v, int e)
    {
        V=v;
        E=e;
        edge = new Edgenode[E];
        for (int i=0;i<E;i++)
        {
            edge[i]= new Edgenode();
        }
    }
    void BMFord(int s)
    {
        int dist[] = new int[V];
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
            int u = edge[j].src;
            int v = edge[j].des;
            int w = edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
              dist[v] = dist[u] + w;
          }
        }

        for (int j = 0; j < E; ++j) {
            int u = edge[j].src;
            int v = edge[j].des;
            int w = edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("CreateGraph contains negative w cycle");
                return;
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args)
    {
        BellmanFord graph=new BellmanFord(4,5);

        graph.edge[0].src = 0;
        graph.edge[0].des = 1;
        graph.edge[0].weight = 5;

        // edge 0 --> 2
        graph.edge[1].src = 0;
        graph.edge[1].des = 2;
        graph.edge[1].weight = 4;

        // edge 1 --> 3
        graph.edge[2].src = 1;
        graph.edge[2].des = 3;
        graph.edge[2].weight = 3;

        // edge 2 --> 1
        graph.edge[3].src = 2;
        graph.edge[3].des = 1;
        graph.edge[3].weight = 6;

        // edge 3 --> 2
        graph.edge[4].src = 3;
        graph.edge[4].des = 2;
        graph.edge[4].weight = 2;

        graph.BMFord(0);
    }
}
