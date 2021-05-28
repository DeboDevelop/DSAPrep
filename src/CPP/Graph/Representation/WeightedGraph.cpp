#include <bits/stdc++.h>
using namespace std;

void addEdge(vector <pair<int, int> > adj[], int u, int v, int wt, bool isDirected)
{
    adj[u].push_back(make_pair(v, wt));
    if(isDirected == false)
    adj[v].push_back(make_pair(u, wt));
}

void printGraph(vector<pair<int,int> > adj[], int V)
{
    int v, w;
    for (int u = 0; u < V; u++)
    {
        cout << "Node " << u << " makes an edge with \n";
        for (auto it = adj[u].begin(); it!=adj[u].end(); it++)
        {
            v = it->first;
            w = it->second;
            cout << "\tNode " << v << " with edge weight ="
                 << w << "\n";
        }
        cout << "\n";
    }
}

int main()
{
    int V = 5;
    bool isDirected = false;
    vector<pair<int, int> > adj[V];
    addEdge(adj, 0, 1, 10, isDirected);
    addEdge(adj, 0, 4, 20, isDirected);
    addEdge(adj, 1, 2, 30, isDirected);
    addEdge(adj, 1, 3, 40, isDirected);
    addEdge(adj, 1, 4, 50, isDirected);
    addEdge(adj, 2, 3, 60, isDirected);
    addEdge(adj, 3, 4, 70, isDirected);
    printGraph(adj, V);
    return 0;
}