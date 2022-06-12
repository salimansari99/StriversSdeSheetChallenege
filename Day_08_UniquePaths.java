import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
        int[][] dp = new int[m+1][n+1];
        return path(m,n,dp);
	}
    //Memoization
    /*
    public static int path(int m, int n, int i, int j, int[][] dp){
        if(i >= m || j >= n) return 0;
        if(dp[i][j]>0) return dp[i][j];
        if(i == m-1 && j == n-1)  return 1;
        
        return  dp[i][j] = path(m,n,i,j+1,dp) + path(m,n,i+1,j,dp);
    }
    */
    
    // Tabulation
     public static int path(int m, int n, int[][] dp){
         for(int i = m-1; i >= 0; i--){
             for(int j = n-1; j >= 0; j--){
                  if(i==m-1 || j==n-1) dp[i][j] = 1;
                 else dp[i][j] = dp[i][j+1] + dp[i+1][j];
             }
         }
         return dp[0][0];
    }
}