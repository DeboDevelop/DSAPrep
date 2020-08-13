import java.util.*;
import java.io.*;
public class Graph
{
    int V;
    boolean directed;
    LinkedList<Integer> adjList[];
    @SuppressWarnings("unchecked")
    Graph(int v, boolean d)
    {
        V=v;
        directed=d;
        adjList = new LinkedList[V];
        for (int i=0;i<V;i++)
        {
            adjList[i]= new LinkedList<Integer>();
        }
    }
    void addEdge(int src, int des)
    {
        adjList[src].add(des);
        if(directed==false)
        {
            adjList[des].add(src);
        }
    }
    void printGraph()
    {
        for (int i=0;i<V;i++)
        {
            System.out.println("Adjacent List of Vertex: "+i);
            for (Integer it: adjList[i] )
            {
                System.out.print("->"+it);
            }
            System.out.println();
        }
    }
    void DFS(int v, boolean visited[])
    {
        System.out.print(v+" ");
        visited[v]=true;
        Iterator<Integer> i=adjList[v].listIterator();

        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFS(n,visited); 
        } 
    }
    void DFShelper(int v)
    {
        boolean visited[] = new boolean[V];

        DFS(v, visited);

        for (int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                DFS(i, visited);
            }
        }
    }
    void DFSStack(int s)
    {
        Vector<Boolean> visited = new Vector<Boolean>(V); 
        for (int i = 0; i < V; i++) 
            visited.add(false); 
  
        Stack<Integer> stack = new Stack<>(); 
        stack.push(s); 
          
        while(stack.empty() == false) 
        {
            s = stack.peek(); 
            stack.pop(); 

            if(visited.get(s) == false) 
            { 
                System.out.print(s + " "); 
                visited.set(s, true); 
            }

            Iterator<Integer> itr = adjList[s].iterator(); 
              
            while (itr.hasNext())  
            { 
                int v = itr.next(); 
                if(!visited.get(v)) 
                    stack.push(v); 
            }
        } 
    }
    void BFS(int v)
    {
        boolean visited[] = new boolean[V];
        Deque<Integer> queue = new ArrayDeque<Integer>();

        visited[v]=true;
        queue.addLast(v);

        while(queue.size()!=0)
        {
            v=queue.pollFirst();
            System.out.print(v+" ");

            Iterator<Integer> i=adjList[v].listIterator();
            while(i.hasNext())
            {
                int n=i.next();
                if(!visited[n])
                {
                    visited[n]=true;
                    queue.addLast(n);
                }
            }
        }
    }
    public static void main(String[] args) 
    {
        Graph g = new Graph(4, true); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        System.out.println("Following is Depth First Traversal (starting from vertex 2)"); 
        g.DFShelper(2);
        System.out.println();
        System.out.println("Following is Breadth First Traversal (starting from vertex 2)"); 
        g.BFS(2); 
        System.out.println();
        System.out.println("Following is Depth First Traversal (starting from vertex 2)");
        g.DFSStack(2);
        System.out.println();
    }
}