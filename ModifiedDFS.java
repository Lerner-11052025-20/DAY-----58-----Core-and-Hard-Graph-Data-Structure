
import java.util.ArrayList;

public class ModifiedDFS
{
    public static class Edge
    {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w)
        {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[])
    {
        // 0 vertex
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 4));

        // 2 vertex
        graph[2].add(new Edge(2, 0, 3));
        graph[2].add(new Edge(2, 4, 6));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 3));
        graph[4].add(new Edge(4, 3, 3));
        graph[4].add(new Edge(4, 5, 3));

        // 5 vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 vertex
        graph[6].add(new Edge(6, 5, 7));
    }

    public static void dfs(ArrayList<Edge> graph[])
    {
        boolean visited[] = new boolean[graph.length];

        for(int i=0 ; i<graph.length ; i++)
        {
            if(!visited[i])
            {
                dfsUtil(graph, visited, i);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[], boolean visited[], int curr)
    {
        System.out.print(curr+ " ");
        visited[curr] = true;

        for(int i=0 ; i<graph[curr].size() ; i++)
        {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest])
            {
                dfsUtil(graph, visited, e.dest);
            }
        }
    }

    public static void main(String args[])
    {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0 ; i<V ; i++)    graph[i] = new ArrayList<>();

        createGraph(graph);
        dfs(graph);
    }
}