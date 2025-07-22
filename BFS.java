import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS
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

    static int V = 7;
    static ArrayList<Edge> graph[] = new ArrayList[V];

    public static void createGraph()
    {
        for(int i=0 ; i<V ; i++)    graph[i] = new ArrayList<>();
        // null arrayList hovathi tya kay pan add nahi thay jethi null------>[] empty AL convert karvu padshe
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
    }

    public static void BFS(boolean visited[])
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // start vertex 0 ne add kari didhi

        while(!q.isEmpty())
        {
            int curr = q.remove();

            if(!visited[curr])
            {
                System.out.print(curr+ " ");
                visited[curr] = true;

                for(int i=0 ; i<graph[curr].size() ; i++)
                {
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }
    public static void main(String args[])
    {
        createGraph();
        BFS(new boolean[V]);
    }
}