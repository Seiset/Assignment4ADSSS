import java.util.*;

public class Graph {
    private int V, E;
    private Vertex[] vertices;
    private LinkedList<Edge>[] adj;

    public Graph(int nodes) {
        this.V = nodes;
        this.vertices = new Vertex[nodes];
        this.adj = new LinkedList[nodes];

        for (int v = 0; v < V; v++) {
            this.vertices[v] = new Vertex(v);
            this.adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v,int weight) {
        Vertex source = vertices[u];
        Vertex destination = vertices[v];

        adj[u].add(new Edge(source, destination,weight));
        adj[v].add(new Edge(destination, source,weight));
    }
    public void addEdge(int u, int v) {
        addEdge(u, v, 1);
    }


    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.print("AdjList[" + v + "]: ");
            for (int w = 0; w < adj[v].size(); w++) {
                System.out.print(adj[v].get(w).getDestination().getId() + " ");
            }
            System.out.println();
        }
    }
    public void dfs() {
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                visitVertex(v, visited);
            }
        }
    }

    public void visitVertex(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int w = 0; w < adj[v].size(); w++) {
            int neighborId = adj[v].get(w).getDestination().getId();
            if (!visited[neighborId]) {
                visitVertex(neighborId, visited);
            }
        }
    }
    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int w = 0; w < adj[u].size(); w++) {
                int neighborId = adj[u].get(w).getDestination().getId();
                if (!visited[neighborId]) {
                    visited[neighborId] = true;
                    q.add(neighborId);
                }
            }
        }
    }

    public void dijkstra(int start) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        for (int count = 0; count < V - 1; count++) {int u = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && dist[v] < minDistance) {
                    minDistance = dist[v];
                    u = v;
                }
            }
            if (u == -1) break;
            visited[u] = true;
            for (int w = 0; w < adj[u].size(); w++) {
                Edge edge = adj[u].get(w);
                int neighborId = edge.getDestination().getId();
                int weight = edge.getWeight();


                if (!visited[neighborId] && dist[u] != Integer.MAX_VALUE
                        && dist[u] + weight < dist[neighborId]) {
                    dist[neighborId] = dist[u] + weight;
                }
            }
        }System.out.println("Dijkstra Shortest Paths " + start + ":");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("  To Vertex " + i + " -> Distance: Unreachable");
            } else {
                System.out.println("  To Vertex " + i + " -> Distance: " + dist[i]);
            }
        }
    }
}
