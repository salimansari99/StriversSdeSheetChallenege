import java.util.*;
public class Solution {
    public static int cutLogs(int k, int n) {
        if(n == 0 || n == 1) return n;
        if(k == 1) return n;
        int[][] dp = new int[k+1][n+1];
        for(int[] r : dp) Arrays.fill(r, -1);
        return solve(k,n, dp);
    }
    /*
    public static int solve(int k, int n, int[][] dp){
        if(n == 0 || n == 1) return n;
        if(k == 1) return n;
        if(dp[k][n] != 0) return dp[k][n];
        int ans = Integer.MAX_VALUE;
        for(int m = 1; m <= n; m++){
            int low;
            if(dp[k-1][m-1] != 0) low = dp[k-1][m-1];
            else{
                low = solve(k-1, m-1, dp);
                dp[k-1][m-1] = low;
            }
            int high;
            if(dp[k][n-m] != 0) high = dp[k][n-m];
            else{
                high = solve(k, n-m, dp);
                dp[k][n-m] = high;
            }
            int temp = 1 + Math.max(low, high);
            if(temp < ans) ans = temp;
        }
        return dp[k][n] = ans;
    }
*/
    
     public static int solve(int k, int n, int[][] dp){
        if(n == 0 || n == 1) return n;
        if(k == 1) return n;
        if(dp[k][n] != -1) return dp[k][n];
        int ans = Integer.MAX_VALUE;
         int l = 1, h = n;
          while(l <= h){
              int mid = l + ((h-l)>>1);
              int below = solve(k-1, mid-1, dp);
              int above = solve(k, n-mid, dp);
              if(above > below) l = mid+1;
              else h = mid-1 ;
              
              int temp = 1 + Math.max(below, above);
              if(temp < ans) ans = temp;
        }
        return dp[k][n] = ans;
    }
}
