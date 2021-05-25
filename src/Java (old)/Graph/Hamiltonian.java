import java.util.*;

public class Hamiltonian {
    public static int findPath(int src, int v,List<List<Integer>> graph, boolean visited[], LinkedList<Integer> path) {
        if (src == v) {
            if(path.size()==graph.size()) {
                System.out.println(path);
                System.exit(0);
            }
            else 
                return -1;
        }

        for (int to: graph.get(v)) {
            if(!visited[to]) {
                visited[to] = true;
                path.add(to);
                int x = findPath(src, to, graph, visited, path);
                if(x == -1) {
                    visited[to] = false;
                    path.removeLast();
                }
            }
        }
        return -1;
    }
     public static void check(List<List<Integer>> graph) {
        if (graph.size()==0) {
            System.out.println(-1);
            return;
        }
        for (int i=0;i<graph.size();i++) {
            if(graph.get(i).size()==0) {
                System.out.println(-1);
                return;
            }
        }
        boolean visited[] = new boolean[graph.size()];

        LinkedList<Integer> l = new LinkedList<>();
        l.add(graph.get(0).get(0));
        System.out.println(findPath(0, graph.get(0).get(0), graph, visited, l));
        // l.add(1);
        // System.out.println(findPath(5, 1, graph, visited, l));
     }
    public static void addEdge(List<List<Integer>> graph, int src, int des) {
        graph.get(src).add(des);
    }
    public static void main(String[] args) {
        int V=8;
        List<List<Integer>> graph = new LinkedList<>();
        for (int i = 0; i < V; i++) 
            graph.add(new LinkedList<>());

        addEdge(graph, 0, 7); 
        addEdge(graph, 7, 5); 
        addEdge(graph, 5, 2);
        addEdge(graph, 5, 1); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 2, 3);
        addEdge(graph, 2, 6);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 2);
        addEdge(graph, 4, 6);
        addEdge(graph, 6, 0);
        check(graph);
    }
}