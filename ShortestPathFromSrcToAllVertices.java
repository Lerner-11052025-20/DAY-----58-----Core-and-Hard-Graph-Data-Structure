import java.util.ArrayList;
import java.util.PriorityQueue;

public class ShortestPathFromSrcToAllVertices
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

    public static class Pair implements Comparable<Pair>
    {
        int n;
        int path;

        Pair(int n, int path)
        {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2)
        {
            return this.path - p2.path; // shortest v || n ne aagal rakhshe pq ma 
        }
    }

    public static void createGraph(ArrayList<Edge> graph[])
    {
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));
        
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static void dijkstras(ArrayList<Edge> graph[], int src)
    {
        int d[] = new int[graph.length];
        for(int i=0 ; i<d.length ; i++)
        {
            if(i != src)    d[i] = Integer.MAX_VALUE;
        }

        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty())
        {
            Pair curr = pq.remove();

            if(!visited[curr.n])
            {
                visited[curr.n] = true;
                
                for(int i=0 ; i<graph[curr.n].size() ; i++)
                {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;     
                    
                    if(d[u] + wt < d[v])
                    { 
                        d[v] = d[u] + wt;
                        pq.add(new Pair(v, d[v]));
                    }
                }
            }
        }

        for(int i: d)   System.out.print(i+ " ");
    }

    public static void main(String args[])
    {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0 ; i<V ; i++)    graph[i] = new ArrayList<>(); // uper 6 aaya loop ma 7 no chale 

        createGraph(graph);
        dijkstras(graph, 0);
    }
}