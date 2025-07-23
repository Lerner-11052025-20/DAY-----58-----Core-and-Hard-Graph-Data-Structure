
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphUsingBFS
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


    public static void createGraph(ArrayList<Edge>[] graph)
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
        // graph[3].add(new Edge(3, 4, 1));
        // graph[3].add(new Edge(3, 5, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 3));
        // graph[4].add(new Edge(4, 3, 3));
        // graph[4].add(new Edge(4, 5, 3));
    }

    public static boolean bfs(ArrayList<Edge>[] graph)
    {
        int color[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ; i<graph.length ; i++)    color[i] = -1;

        for(int i=0 ; i<graph.length ; i++)
        {
            if(color[i] == -1)
            {
                color[i] = 0;
                q.add(i);
                return bfsUtil(graph, color, q);                
            }
        }

        return false; // aaya nay aave pan for ni under if hovathi aa lakhavu padshe
    }

    public static boolean bfsUtil(ArrayList<Edge>[] graph, int color[], Queue<Integer> q)
    {
        while(!q.isEmpty())
        {
            System.out.println(q);
            int curr = q.remove();

            for(int i=0 ; i<graph[curr].size() ; i++)
            {
                Edge e = graph[curr].get(i);
                if(color[e.dest] == -1)
                {
                    int nextColor = color[curr] == 0 ? 1 : 0;
                    color[e.dest] = nextColor;
                    q.add(e.dest);
                }
                else if(color[e.dest] == color[curr])
                {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String args[])
    {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0 ; i<V ; i++)    graph[i] = new ArrayList<>();

        createGraph(graph);
        System.out.println(bfs(graph));
    }
}