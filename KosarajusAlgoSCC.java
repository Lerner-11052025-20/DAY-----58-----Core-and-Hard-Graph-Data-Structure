import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgoSCC
{
    public static class Edge
    {
        int src;
        int dest;

        Edge(int u,int v)
        {
            this.src = u;
            this.dest = v;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[])
    {
        // graph[0].add(new Edge(0, 2));
        // graph[2].add(new Edge(2, 1));
        // graph[1].add(new Edge(1, 0));
        // graph[0].add(new Edge(0, 3));
        // graph[3].add(new Edge(3, 4));
        
        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 5));
        graph[1].add(new Edge(1, 0));
        graph[5].add(new Edge(5, 3));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 5));
    }

    public static void topoSort(ArrayList<Edge> graph[], boolean visited[], Stack<Integer> s, int curr)
    {
        visited[curr] = true;

        for(int i=0 ; i<graph[curr].size() ; i++)
        {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest])
            {
                topoSort(graph, visited, s, e.dest);
            }
        }
        
        s.push(curr);
    }
    
    public static void dfsUtil(ArrayList<Edge> transpose[], int curr, boolean visited[])
    {
        System.out.print(curr+ " ");
        visited[curr] = true;

        for(int i=0 ; i<transpose[curr].size() ; i++)
        {
            Edge e = transpose[curr].get(i);
            if(!visited[e.dest])
            {
                dfsUtil(transpose, e.dest, visited);
            }
        }
    }

    public static void kosarajus(ArrayList<Edge> graph[], int V)
    {
        // step[1] -----> topo sort with stack DFS
        boolean visited[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        topoSort(graph, visited, s, 0);

        // step[2] -----> transpose of a graph
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i=0 ; i<V ; i++)
        {
            transpose[i] = new ArrayList<>();
            visited[i] = false;
        }
        for(int i=0 ; i<V ; i++)
        {
            for(int j=0 ; j<graph[i].size() ; j++)
            {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        
        // step[3] -----> transpose graph per dfs with Stack element
        while(!s.isEmpty())
        {
            int ele = s.pop();
            if(!visited[ele])
            {
                System.out.print("SCC ----> ");
                dfsUtil(transpose, ele, visited);
                System.out.println();
            }
        }
    }

    public static void main(String args[])
    {
        // int  V = 5;
        int  V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i=0 ; i<V ; i++)
        {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        kosarajus(graph, V);
    }
}