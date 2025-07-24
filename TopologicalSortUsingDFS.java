import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortUsingDFS
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

        // 1 vertex
        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 3, 4));

        // 2 vertex
        graph[2].add(new Edge(2, 3, 3));
        // graph[2].add(new Edge(2, 4, 6));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 4, 1));
        // graph[3].add(new Edge(3, 5, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 0, 3));
        graph[4].add(new Edge(4, 1, 3));
        // graph[4].add(new Edge(4, 5, 3));

        // 5 vertex
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
        // graph[5].add(new Edge(5, 6, 1));

        // 6 vertex
        // graph[6].add(new Edge(6, 5, 7));
    }

    public static void dfs(ArrayList<Edge> graph[])
    {
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0 ; i<graph.length ; i++)
        {
            if(!visited[i])
            {
                dfsUtil(graph, visited, i, s);
            }
        }

        while(!s.isEmpty())  System.out.print(s.pop()+ " ");
    }

    public static void dfsUtil(ArrayList<Edge> graph[], boolean visited[], int curr, Stack<Integer> s)
    {
        visited[curr] = true;

        for(int i=0 ; i<graph[curr].size() ; i++)
        {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest])
            {
                dfsUtil(graph, visited, e.dest, s);
            }
        }

        s.push(curr);
    }

    public static void main(String args[])
    {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0 ; i<V ; i++)    graph[i] = new ArrayList<>(); // uper 6 aaya loop ma 7 no chale 

        createGraph(graph);
        dfs(graph);
    }
}