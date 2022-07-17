public class Solution {
    public static int minSumPath(int[][] grid) {
    	
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        //return minPath(0, 0, n, m, grid, dp);
        return minPathDP(n, m, grid);
    }
    /* Memoization
    public static int minPath(int i, int j, int n, int m, int[][] grid, int[][] dp){
        if(i < 0 || i >= n || j < 0 || j >= m) return Integer.MAX_VALUE;
        
        if(i == n-1 && j == m-1) return grid[i][j];
        
        if(dp[i][j] != 0) return dp[i][j];
        int a1 = minPath(i, j+1, n, m, grid, dp);
        int a2 = minPath(i+1, j, n, m, grid, dp);
        return  dp[i][j] = grid[i][j] + Math.min(a1, a2); 
    }
    */
      public static int minPathDP(int n, int m, int[][] grid){
          
          int[][] dp = new int[n][m];
          
          for(int i = n-1; i >= 0; i--){
              for(int j = m-1; j >= 0; j--){
                  if(i == n-1 && j == m-1) dp[i][j] = grid[i][j];
                  else if(i == n-1){
                      dp[i][j] = grid[i][j] + dp[i][j+1];
                  }
                  else if(j == m-1){
                      dp[i][j] = grid[i][j] + dp[i+1][j];
                  }
                  else{
                      dp[i][j] = grid[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
                  }
              }
          }
          return dp[0][0];  
    }
}