import java.util.*;

public class AP {

    static class Edge {
        int src, dest;
        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Function to create the graph shown in the image
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // ✅ GRAPH from Tarjan’s Algorithm IMAGE
        // 1 -- 0 -- 3 -- 4
        //  |   /
        //  |  /
        //  2
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        graph[0].add(new Edge(0, 3));
        graph[3].add(new Edge(3, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
    }

    // 🔵 Tarjan’s DFS to find articulation points
    public static void dfs(ArrayList<Edge>[] graph, int curr, int parent, int[] dt, int[] low, boolean[] vis, int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (neigh == parent) {
                continue; // Skip the edge leading back to parent
            }

            if (vis[neigh]) {
                // Back edge
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                // Forward edge
                dfs(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);

                if (parent != -1 && dt[curr] <= low[neigh]) {
                    System.out.println("AP: " + curr);
                }
                children++;
            }
        }

        if (parent == -1 && children > 1) {
            System.out.println("AP: " + curr);
        }
    }

    // 🔵 Driver for articulation point finding
    public static void getAP(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        int time = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time);
            }
        }
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        getAP(graph, V);
    }
}
