import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBFS
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
        graph[2].add(new Edge(2, 3, 3));

        graph[3].add(new Edge(3, 1, 1));
        
        graph[4].add(new Edge(4, 0, 3));
        graph[4].add(new Edge(4, 1, 3));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }

    public static void indegree(ArrayList<Edge> graph[], int in[])
    {
        for(int i=0 ; i<graph.length ; i++)
        {
            for(int j=0 ; j<graph[i].size() ; j++)
            {
                Edge e = graph[i].get(j);
                in[e.dest]++;
            }
        }
    }

    public static void kahns(ArrayList<Edge> graph[])
    {
        int in[] = new int[graph.length];
        indegree(graph, in);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ; i<in.length ; i++)
        {
            if(in[i] == 0)  q.add(i);
        }

        while(!q.isEmpty())
        {
            int curr = q.remove();
            System.out.print(curr+ " ");

            for(int i=0 ; i<graph[curr].size() ; i++)
            {
                Edge e = graph[curr].get(i);
                in[e.dest]--;
                if(in[e.dest] == 0)     q.add(e.dest);
            }
        }
    }

    public static void main(String args[])
    {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0 ; i<V ; i++)    graph[i] = new ArrayList<>(); // uper 6 aaya loop ma 7 no chale 

        createGraph(graph);
        kahns(graph);
    }
}