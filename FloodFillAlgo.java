public class FloodFillAlgo {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgCol = image[sr][sc];
        if (orgCol == color) return image;  // ✅ No need to flood if already same color

        boolean[][] vis = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, orgCol);
        return image;
    }

    public static void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgCol) {
        // ✅ Base Case: Out of bounds, already visited, or different color
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length ||
            vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }

        // Fill color & mark visited
        image[sr][sc] = color;
        vis[sr][sc] = true;

        // \U0001f504 Recursive calls in all four directions
        helper(image, sr, sc - 1, color, vis, orgCol); // left
        helper(image, sr, sc + 1, color, vis, orgCol); // right
        helper(image, sr - 1, sc, color, vis, orgCol); // up
        helper(image, sr + 1, sc, color, vis, orgCol); // down
    }

    public static void main(String args[])
    {
        int image[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(image, 1, 1, 2);
        
        for(int i[]: image)
        {
            for(int j: i)
            {
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }
}
