
import java.util.ArrayList;

public class GraphCreation
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

    public static void main(String args[])
    {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];

        System.out.println(graph[0]); // non-primitive dt hovathi null thij intialize thase

        for(int i=0 ; i<graph.length ; i++)
        {
            graph[i] = new ArrayList<>();
            System.out.println(graph[i]);
        }

        // je graph ma VERTEX hashe tej mara adjacency list ma array ni index both same thase
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

        System.out.println(graph[3].get(1));

        // vertex 3's all neighbours find out
        for(int i=0 ; i<graph[5].size() ; i++)
        {
            System.out.println(graph[5].get(i).dest);
        }
    }
}