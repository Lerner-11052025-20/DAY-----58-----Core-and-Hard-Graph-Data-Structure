import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingCitiesWithMinimumCost
{
    public static class Edge implements Comparable<Edge>
    {
        int dest;
        int cost;

        Edge(int dest, int cost)
        {
            this.dest = dest;
            this.cost = cost;
        }

        @Override // object ne compare karine pq ma store to karvano j hoy to j te min valo aagal aavshe
        public int compareTo(Edge e2)
        {
            return this.cost - e2.cost;
        }
    }

    public static void prims(ArrayList<Edge> edges, int cities[][])
    {
        int finalCost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        boolean visited[] = new boolean[cities.length];

        while(!pq.isEmpty())
        {
            Edge curr = pq.remove();

            if(!visited[curr.dest])
            {
                visited[curr.dest] = true;
                finalCost += curr.cost;

                for(int i=0 ; i<cities[curr.dest].length ; i++) // i->row as curr.dest j-> as i here 0 1 2 3 4 column per
                {
                    if(cities[curr.dest][i] != 0)
                    {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        System.out.println(finalCost);
    }



    public static void main(String args[])
    {
        int cities[][] = {{0, 1, 2, 3, 4}, //  2D array ma only weight j given chhe
                        {1, 0, 5, 0, 7},
                        {2, 5, 0, 6, 0},
                        {3, 0, 6, 0, 0},
                        {4, 7, 0, 0, 0}};
        
        ArrayList<Edge> edges = new ArrayList<>();

        prims(edges, cities);
    
    }
}