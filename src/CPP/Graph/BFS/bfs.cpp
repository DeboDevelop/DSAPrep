#include <bits/stdc++.h>
using namespace std;

vector<int> bfsOfGraph(int V, vector<int> adj[]) {
    vector<int> bfs;
    vector<int> vis(V, 0);

    for(int i = 0; i < V; i++) {

        if(!vis[i]) {
            queue<int> q;
            q.push(i);
            vis[i] = 1;

            while(!q.empty()) {
                int node = q.front();
                q.pop();
                bfs.push_back(node);

                for(auto it: adj[node]) {
                    if(!vis[it]) {
                        q.push(it);
                        vis[it] = 1;
                    }
                }
            }
        }
    }
    return bfs;
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

    vector<int> ans = bfsOfGraph(V, adj);
    for(int i = 0; i < ans.size(); i++) {
        cout << ans[i] << " ";
    }

    cout << "\n";
    return 0;
}
