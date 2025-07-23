import java.util.ArrayList;

public class DirectedGraphCYcleDetectionUsingDFS
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
        // 0 vertex
        graph[0].add(new Edge(0, 2, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));

        // 2 vertex
        // graph[2].add(new Edge(2, 0, 3));
        graph[2].add(new Edge(2, 3, 3));

        // 3 vertex
        graph[3].add(new Edge(3, 0, 1));        
    }

    public static boolean stack[] = new boolean[4];

    public static boolean detectCycle(ArrayList<Edge> graph[])
    {
        boolean visited[] = new boolean[graph.length];

        for(int i=0 ; i<graph.length ; i++)
        {
            if(!visited[i])
            {
                if(detectCycleUtil(graph, visited, i, stack))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean visited[], int curr, boolean stack[])
    {
        visited[curr] = true;
        stack[curr] = true;

        for(int i=0 ; i<graph[curr].size() ; i++)
        {
            Edge e = graph[curr].get(i);

            if(stack[e.dest])
            {
                return true;
            }
            else if(!visited[e.dest])
            {
                if(detectCycleUtil(graph, visited, e.dest, stack))
                {
                    return true;
                }
            }
            
        }
        
        stack[curr] = false;
        return false;
    }

    public static void main(String args[])
    {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0 ; i<V ; i++)    graph[i] = new ArrayList<>();

        createGraph(graph);
        System.out.println(detectCycle(graph));

        for(boolean i: stack)   System.out.print(i+ " ");
    }
}