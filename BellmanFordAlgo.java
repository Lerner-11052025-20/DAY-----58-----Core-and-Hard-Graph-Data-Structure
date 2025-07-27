import java.util.ArrayList;

public class BellmanFordAlgo
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
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));
        
        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src)
    {
        int d[] = new int[graph.length];
        for(int i=0 ; i<graph.length ; i++)     if(i != src)    d[i] = Integer.MAX_VALUE;

        int V = graph.length;
        for(int i=0 ; i<V-1 ; i++) {
            for(int j=0 ; j<graph.length ; j++) {
                for(int k=0 ; k<graph[j].size() ; k++) {
                    Edge e = graph[j].get(k);
                    if(d[e.src] != Integer.MAX_VALUE && d[e.src] + e.wt < d[e.dest])    d[e.dest] = d[e.src] + e.wt;
                }
            }
        }

        for(int i: d)   System.out.print(i+ " ");
    }

    public static void main(String args[])
    {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0 ; i<V ; i++)    graph[i] = new ArrayList<>(); // uper 6 aaya loop ma 7 no chale 

        createGraph(graph);
        bellmanFord(graph, 0);
    }
}