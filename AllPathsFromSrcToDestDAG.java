import java.util.ArrayList;

public class AllPathsFromSrcToDestDAG
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
        graph[0].add(new Edge(0, 3, 1));

        graph[2].add(new Edge(2, 3, 3));

        graph[3].add(new Edge(3, 1, 1));
        
        graph[4].add(new Edge(4, 0, 3));
        graph[4].add(new Edge(4, 1, 3));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }

    public static void allPaths(ArrayList<Edge> graph[], ArrayList<Integer> list, int src, int dest)
    {
        if(src == dest)
        {
            list.add(dest);
            System.out.println(list);
            list.remove(dest);
            return;
        }

        for(int i=0 ; i<graph[src].size() ; i++)
        {
            Edge e = graph[src].get(i);
            list.add(src);
            allPaths(graph, list, e.dest, dest);
            list.remove(list.size()-1); // backtracking step [5, 5, 2, 3, 1] jethi have 5 remove thase pehla and pachi added
        }
    }

    public static void main(String args[])
    {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0 ; i<V ; i++)    graph[i] = new ArrayList<>(); // uper 6 aaya loop ma 7 no chale 

        createGraph(graph);
        allPaths(graph, new ArrayList<>(), 5, 1);
    }
}