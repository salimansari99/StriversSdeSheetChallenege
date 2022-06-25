import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[][] vis = new int[n][n];
        ratInMaze(maze,n,0,0,vis,res);
        return res;
    }
    public static void ratInMaze(int[][] maze, int n, int i, int j, int[][] vis, ArrayList<ArrayList<Integer>> res){
        if(maze[n-1][n-1] == 0) return;
        if(!isValid(i,j,n)) return;
        
        vis[i][j] = 1;
        
        if(i == n-1 && j == n-1){
            ArrayList<Integer> ds = new ArrayList<>();
            for(int k = 0; k < n; k++){
                for(int l = 0; l < n; l++){
                    ds.add(vis[k][l]);
                }
            }
            res.add(ds);
            vis[i][j] = 0;
            return;
        }
       
        //right
        if(isValid(i,j+1,n) && maze[i][j+1] == 1 && vis[i][j+1] == 0)
            ratInMaze(maze,n,i,j+1,vis,res);
        
        //left
        if(isValid(i,j-1,n) && maze[i][j-1] == 1 && vis[i][j-1] == 0)
            ratInMaze(maze,n,i,j-1,vis,res);
        
        //top
        if(isValid(i-1,j,n) && maze[i-1][j] == 1 && vis[i-1][j] == 0)
            ratInMaze(maze,n,i-1,j,vis,res);
        
        //down
        if(isValid(i+1,j,n) && maze[i+1][j] == 1 && vis[i+1][j] == 0)
            ratInMaze(maze,n,i+1,j,vis,res);
        
        vis[i][j] = 0;
        
    }
    public static boolean isValid(int i, int j, int n){
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}