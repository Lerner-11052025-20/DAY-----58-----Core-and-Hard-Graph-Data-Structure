import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgoMST
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
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static class Pair implements Comparable<Pair>
    {
        int v;
        int cost;

        Pair(int v, int cost)
        {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2)
        {
            return this.cost - p2.cost;
        }
    }

    public static void prims(ArrayList<Edge> graph[], int src)
    {
        int finalCost = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        boolean visited[] = new boolean[graph.length];

        while(!pq.isEmpty())
        {
            Pair curr = pq.remove();

            if(!visited[curr.v])
            {
                visited[curr.v] = true;
                finalCost += curr.cost;

                for(int i=0 ; i<graph[curr.v].size() ; i++)
                {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println(finalCost);
    }

    public static void main(String args[])
    {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0 ; i<V ; i++)    graph[i] = new ArrayList<>(); // uper 6 aaya loop ma 7 no chale 

        createGraph(graph);
        prims(graph, 0);
    }
}