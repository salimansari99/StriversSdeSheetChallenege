/************BFS*************/

import java.util.*;
public class Solution 
{
    public static int getTotalIslands(int[][] mat) 
    {
        int n = mat.length, m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1 && !vis[i][j]){
                    bfs(i, j, mat, vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void bfs(int i, int j, int[][] mat, boolean[][] vis){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j] = true;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        
        while(!q.isEmpty()){
            int[] point = q.poll();
            for(int[] dir : dirs){
                int r = point[0] + dir[0];
                int c = point[1] + dir[1];
                if(valid(r, c, mat) && mat[r][c] == 1 && !vis[r][c]){
                    q.add(new int[]{r, c});
                    vis[r][c] = true;
                }
            }
        }
    }
    public static boolean valid(int r, int c, int[][] mat){
        return r >= 0 && r < mat.length && c >= 0 && c < mat[0].length;
    }
}

/************DFS**************/
/*
import java.util.*;
public class Solution 
{
    public static int getTotalIslands(int[][] mat) 
	{
        int n = mat.length, m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1 && !vis[i][j]){
                    dfs(i, j, mat, vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void dfs(int i, int j, int[][] mat, boolean[][] vis){
        
        vis[i][j] = true;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        
            for(int[] dir : dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(valid(r, c, mat) && mat[r][c] == 1 && !vis[r][c]){
                   dfs(r,c, mat, vis);
            }
        }
    }
    public static boolean valid(int r, int c, int[][] mat){
        return r >= 0 && r < mat.length && c >= 0 && c < mat[0].length;
    }
}
*/