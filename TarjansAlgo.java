import java.util.ArrayList;

public class TarjansAlgo 
{
    public static class Edge
    {
        int src;
        int dest;

        Edge(int u, int v)
        {
            this.src = u;
            this.dest = v;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int V)
    {
        for(int i=0 ; i<V ; i++)
        {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));
        
        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 5));
    }

    public static void dfsUtil(ArrayList<Edge> graph[], int dt[], int low[], boolean visited[] ,int time, int curr, int par)
    {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time; // time++ dt and low update no thatt kemke time assign pehla and the time increment [pan ++time lakhavathi time++ pehla pachi assign]

        for(int i=0 ; i<graph[curr].size() ; i++)
        {
            Edge e = graph[curr].get(i);

            //case[1] ----> visited hoy as well as par hoy
            if(visited[e.dest] && e.dest == par)
            {
                continue;
            }
            //case[2] ----> visited no hoy
            else if(!visited[e.dest])
            {
                dfsUtil(graph, dt, low, visited, time, e.dest, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);
                
                if(dt[e.src] < low[e.dest])
                {
                    System.out.println("Bridge Edge : " +e.src+ " ------ " +e.dest);
                }
            }
            //case[3] ----> visited hoy as well as par NO hoy
            else
            {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }            
        }
    }

    public static void tarjansAlgo(ArrayList<Edge> graph[], int V)
    {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean visited[] = new boolean[V];

        for(int i=0 ; i<V ; i++)
        {
            if(!visited[i])
            {
                dfsUtil(graph, dt, low, visited, time, i, -1);
            }
        }
    }

    public static void main(String args[])
    {
        // int V = 6;
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        tarjansAlgo(graph, V);
    }
}