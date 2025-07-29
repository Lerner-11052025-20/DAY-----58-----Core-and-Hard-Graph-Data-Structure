import java.util.ArrayList;
import java.util.Collections;


public class KruskalsAlgo 
{
    public static int n = 4;
    public static int par[] = new int[n];
    public static int rank[] = new int[n];

    public static class FindUnion
    {
        void init()
        {
            for(int i=0 ; i<n ; i++)    par[i] = i;
        }

        int find(int x)
        {
            if(x == par[x])     return x;

            return par[x] = find(par[x]);
        }

        void union(int a, int b)
        {
            int parA = find(a);
            int parB = find(b);

            if(parA == parB)    System.out.println("RETURN TO HOME");

            if(rank[parA] == rank[parB])
            {
                par[parB] = parA;
                rank[parA]++;
            }
            else if(rank[parA] > rank[parB])
            {
                par[parB] = parA;
            }
            else
            {
                par[parA] = parB;
            }
        }
    }

    public static class Edge implements Comparable<Edge>
    {
        int src;
        int dest;
        int cost;

        Edge(int src, int dest, int cost)
        {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }

        @Override // object ne compare karine pq ma store to karvano j hoy to j te min valo aagal aavshe
        public int compareTo(Edge e2)
        {
            return this.cost - e2.cost;
        }
    }

    public static void kruskalsAlgo(ArrayList<Edge> edges)
    {
        FindUnion f = new FindUnion();
        f.init();

        Collections.sort(edges);
        int finalCost = 0;
        int count = 0;

        for(int i=0 ; count<n-1 ; i++)
        {
            Edge e = edges.get(i);

            int parA = f.find(e.src);
            int parB = f.find(e.dest);

            if(parA != parB)    // == hoy to cycle je chale nay
            {
                f.union(e.src, e.dest);
                finalCost += e.cost;
                count++;
            }
        }

        System.out.println(finalCost);
    }

    public static void main(String args[])
    {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));

        kruskalsAlgo(edges);
    }    
}
