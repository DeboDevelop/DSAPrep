import java.util.LinkedList; 
import java.util.TreeSet; 
import java.util.Comparator;

public class prim
{
    class node
    {
        int dest,weight;
        node(int d, int w)
        {
            dest=d;
            weight=w;
        }
    }
    int V;
    LinkedList<node> adjList[];
    @SuppressWarnings("unchecked")
    prim(int v)
    {
        V=v;
        adjList = new LinkedList[V];
        for (int i=0;i<V;i++)
        {
            adjList[i] = new LinkedList<>();
        }
    }
    class heapnode
    {
        int vertex, key;
    }

    class comparator implements Comparator<heapnode>
    {
        @Override
        public int compare(heapnode n1, heapnode n2)
        {
            return n1.key - n2.key;
        }
    }

    void addEdge(int src, int dest, int weight)
    {
        node n1=new node(dest, weight);
        node n2=new node(src, weight);
        adjList[src].addLast(n1);
        adjList[dest].addLast(n2);
    }
    void primsMST()
    {
        Boolean mstset[]=new Boolean[V];
        heapnode e[]=new heapnode[V];

        int parent[]=new int[V];

        for (int i=0;i<V;i++)
        {
            e[i]=new heapnode();
        }
        for (int i=0;i<V;i++)
        {
            mstset[i]=false;

            e[i].key=Integer.MAX_VALUE;
            e[i].vertex=i;
            parent[i]=-1;
        }
        mstset[0]=true;

        e[0].key=0;

        // Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java. 
        TreeSet<heapnode> queue = new TreeSet<heapnode>(new comparator()); 

        for (int i=0;i<V;i++)
        {
            queue.add(e[i]);
        }

        while(queue.isEmpty()==false)
        {
            heapnode n1=queue.pollFirst();

            mstset[n1.vertex]=true;

            for (node iterator : adjList[n1.vertex])
            {
                // If V is in queue 
                if (mstset[iterator.dest] == false) { 
                    // If the key value of the adjacent vertex is 
                    // more than the extracted key 
                    // update the key value of adjacent vertex 
                    // to update first remove and add the updated vertex 
                    if (e[iterator.dest].key > iterator.weight) { 
                        queue.remove(e[iterator.dest]); 
                        e[iterator.dest].key = iterator.weight; 
                        queue.add(e[iterator.dest]); 
                        parent[iterator.dest] = n1.vertex; 
                    } 
                }
            }
        }

        for (int i=1;i<V;i++)
        {
            System.out.println(parent[i]+" - "+i);
        }
    }
    public static void main(String[] args) 
    { 
        prim p = new prim(9); 
  
        p.addEdge(0, 1, 4); 
        p.addEdge(0, 7, 8); 
        p.addEdge(1, 2, 8); 
        p.addEdge(1, 7, 11); 
        p.addEdge(2, 3, 7); 
        p.addEdge(2, 8, 2); 
        p.addEdge(2, 5, 4); 
        p.addEdge(3, 4, 9); 
        p.addEdge(3, 5, 14); 
        p.addEdge(4, 5, 10); 
        p.addEdge(5, 6, 2); 
        p.addEdge(6, 7, 1); 
        p.addEdge(6, 8, 6); 
        p.addEdge(7, 8, 7); 
  
        p.primsMST();
    } 
}