public class DisjointSetUnionDS 
{
    public static int n = 8;
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
    public static void main(String args[])
    {
        FindUnion f = new FindUnion();
        f.init();
        f.union(1, 3);
        System.out.println(f.find(3));
        System.out.println(f.find(1));
        System.out.println(f.find(4));
        f.union(3, 4);
        System.out.println(f.find(4));

        f.union(6, 7);
        f.union(3, 6);
        System.out.println(rank[1] +" "+ rank[6]);
        System.out.println(f.find(6));
    }    
}
