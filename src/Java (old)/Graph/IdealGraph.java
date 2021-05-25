import java.util.*;

public class IdealGraph {

    public static void DFS(List<List<Integer>> graph, int s)
    {
        Boolean visited[] = new Boolean[graph.size()];
        Arrays.fill(visited, false); 
  
        Deque<Integer> stack = new ArrayDeque<>(); 
        stack.push(s); 
          
        while(stack.size() != 0 ) 
        {
            s = stack.pop(); 
            
            if(visited[s] == false) 
            { 
                System.out.print(s + " "); 
                visited[s] = true; 
            }

            for(int v : graph.get(s))
            { 
                if(!visited[v]) 
                    stack.push(v); 
            }
        } 
    }
    public static void BFS(List<List<Integer>> graph, int v)
    {
        boolean visited[] = new boolean[graph.size()];
        Deque<Integer> queue = new ArrayDeque<Integer>();

        visited[v]=true;
        queue.addLast(v);

        while(queue.size()!=0)
        {
            v=queue.pollFirst();
            System.out.print(v+" ");

            for (int n : graph.get(v))
            {
                if(!visited[n])
                {
                    visited[n]=true;
                    queue.addLast(n);
                }
            }
        }
    }
    // Adds a directed edge from node 'from' to node 'to'
    public static void addEdge(List<List<Integer>> graph, int src, int des) {
        graph.get(src).add(des);
    }
    public static void main(String[] args) {
        int V=5;
        List<List<Integer>> graph = new LinkedList<>();
        for (int i = 0; i < V; i++) 
            graph.add(new LinkedList<>());

        addEdge(graph, 0, 1); 
        addEdge(graph, 0, 2); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 2, 0); 
        addEdge(graph, 2, 3); 
        addEdge(graph, 3, 3);
        System.out.println("DFS");
        DFS(graph, 0);
        System.out.println("\nBFS");  
        BFS(graph, 0);
        System.out.println();
    }
}