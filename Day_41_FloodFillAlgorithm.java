import java.util.*;
public class Solution
{
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
        int n = image.length, m = image[0].length;
        int oldcolor = image[x][y];
        if(oldcolor == newColor) return image; 
        
        bfs(image, x, y, oldcolor, newColor);
        return image;
    }
        public static void bfs(int[][] image, int x, int y, int oldcolor, int newColor){
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        image[x][y] = newColor;
        
        while(!q.isEmpty()){ 
           int[] arr = q.poll(); 
            for(int[] dir : dirs){
                int r = arr[0] + dir[0];
                int c = arr[1] + dir[1];
                if(valid(r,c,image) && image[r][c] == oldcolor){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
       
    }
    public static boolean valid(int x, int y, int[][] image){
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }
}

