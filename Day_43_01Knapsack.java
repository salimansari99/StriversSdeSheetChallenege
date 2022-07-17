import java.util.ArrayList;

public class Solution {
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		
        if(n == 0 || w == 0) return 0;
        int[][] dp = new int[n+1][w+1];
        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        for(int i = 0; i <= w; i++) dp[0][i] = 0;
        return knapsackDP(values, weights, n, w, dp);
	}
    /* Recursion
    public static int knapsack(ArrayList<Integer> v, ArrayList<Integer> wt, int n, int W){
        if(n == 0 || W == 0) return 0;
        
        if(wt.get(n-1) <= W){
            int ans1 = v.get(n-1) + knapsack(v, wt, n-1, W-wt.get(n-1));
            int ans2 = knapsack(v, wt, n-1, W);
            return Math.max(ans1, ans2);
        }
        else return knapsack(v, wt, n-1, W);
    }
    */
    /* Memoization
      public static int knapsackMem(ArrayList<Integer> v, ArrayList<Integer> wt, int n, int W, int[][] dp){
        if(n == 0 || W == 0) return 0;
        if(dp[n][W] != 0) return dp[n][W];
        if(wt.get(n-1) <= W){
            int ans1 = v.get(n-1) + knapsackMem(v, wt, n-1, W-wt.get(n-1), dp);
            int ans2 = knapsackMem(v, wt, n-1, W, dp);
            return dp[n][W] = Math.max(ans1, ans2);
        }
        else return dp[n][W] =  knapsackMem(v, wt, n-1, W, dp);
    }
    */
    
      public static int knapsackDP(ArrayList<Integer> v, ArrayList<Integer> wt, int n, int W, int[][] dp){
        if(n == 0 || W == 0) return 0;
       
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                  if(wt.get(i-1) <= j){
                      int ans1 = v.get(i-1) + dp[i-1][j-wt.get(i-1)];
                      int ans2 = dp[i-1][j];
                      dp[i][j] = Math.max(ans1, ans2);
                    }
                  else dp[i][j] =  dp[i-1][j];
            }
        }  
        return dp[n][W];    
    }
}