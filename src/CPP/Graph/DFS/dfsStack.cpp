#include <bits/stdc++.h>
using namespace std;

void dfsRecursion(int node, vector<int> &vis, vector<int> adj[], vector<int> &dfs) {
    dfs.push_back(node);
    vis[node] = 1;

    for(auto it: adj[node]) {
        if(!vis[it]) {
            dfsRecursion(it, vis, adj, dfs);    
        }
    }
}

vector<int> dfsOfGraph(int V, vector<int> adj[]) {
    vector<int> dfs;
    vector<int> vis(V, 0);

    for(int i = 0; i < V; i++) {
        if(!vis[i]) {
            dfsRecursion(i, vis, adj, dfs);  
        }
    }
    
    return dfs;
}

void addEdge(vector<int> adj[], int u, int v, bool isDirected)
{
    adj[u].push_back(v);
    if(isDirected == false)
    adj[v].push_back(u);
}

void printGraph(vector<int> adj[], int V)
{
    for (int v = 0; v < V; ++v)
    {
        cout << "\n Adjacency list of vertex " << v << "\n head ";
        for (auto x : adj[v])
           cout << "-> " << x;
        cout << "\n";
    }
}
 
// Driver code
int main()
{
    int V = 5;
    bool isDirected = false;
    vector<int> adj[V];

    addEdge(adj, 0, 1, isDirected);
    addEdge(adj, 0, 4, isDirected);
    addEdge(adj, 1, 2, isDirected);
    addEdge(adj, 1, 3, isDirected);
    addEdge(adj, 1, 4, isDirected);
    addEdge(adj, 2, 3, isDirected);
    addEdge(adj, 3, 4, isDirected);

    vector<int> ans = dfsOfGraph(V, adj);
    for(int i = 0; i < ans.size(); i++) {
        cout << ans[i] << " ";
    }

    cout << "\n";
    return 0;
}
