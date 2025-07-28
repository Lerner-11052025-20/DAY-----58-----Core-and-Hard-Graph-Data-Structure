import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithKstops
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

    public static class Info
    {
        int v;
        int cost;
        int k;

        Info(int v, int cost, int k)
        {
            this.v = v;
            this.cost = cost;
            this.k = k;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int flights[][], int V)
    {
        for(int i=0 ; i<V ; i++)    graph[i] = new ArrayList<>();

        for(int i=0 ; i<flights.length ; i++)
        {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            graph[src].add(new Edge(src, dest, wt));
        }
    }

    public static int dijkstras(ArrayList<Edge> graph[], int SRC, int DEST, int K)
    {
        int d[] = new int[graph.length];
        for(int i=0 ; i<d.length ; i++)
        {
            if(i != SRC)    d[i] = Integer.MAX_VALUE;
        }

        // visited ni jarur aatla mate nathi kemke hu curr.k > K thay jay tyare break; karavano chhu jethi repeatition thase j nahi
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(SRC, 0, 0)); //  0 0 0

        while(!q.isEmpty())
        {
            Info curr = q.remove();

            if(curr.k > K)  break;

            for(int i=0 ; i<graph[curr.v].size() ; i++)
            {
                Edge e = graph[curr.v].get(i);

                if(curr.k <= K && curr.cost + e.wt < d[e.dest])
                {
                    d[e.dest] = curr.cost + e.wt;
                    q.add(new Info(e.dest, d[e.dest], curr.k+1));
                }
            }
        }

        return d[DEST] != Integer.MAX_VALUE ? d[DEST] : -1 ;
    }

    public static void main(String args[])
    {
        int n = 4; // means 4 cities are given
        int flights[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dest = 3, K = 1;

        int V = n;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph, flights, V);
        System.out.println(dijkstras(graph, src, dest, K));
    }
}