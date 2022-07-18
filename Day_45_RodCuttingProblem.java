public class Solution {
	public static int cutRod(int price[], int n) {
		int len = price.length;
        //return knapsack(price, len, 1, n);
        int[][] dp = new int[len+1][n+1];
       // return knapsackMem(price, len, 1, n, dp);
        
        return knapsackDP(price, len, 1, n);
        
	}
    /*
     public static int knapsack(int[] arr, int n, int st, int len){
        if(st > n) return 0;
        
        
        if(st <= len){
            int a1 = arr[st-1] + knapsack(arr, n, st, len-st);
            int a2 = knapsack(arr, n, st+1, len);
            return Math.max(a1,a2);
        }
        else return knapsack(arr, n, st+1, len);
        
    }
    */
    /*
    public static int knapsackMem(int[] arr, int n, int st, int len, int[][] dp){
        if(st > n) return 0;
        
        if(dp[st][len] != 0) return dp[st][len];
        if(st <= len){
            int a1 = arr[st-1] + knapsackMem(arr, n, st, len-st, dp);
            int a2 = knapsackMem(arr, n, st+1, len, dp);
            return dp[st][len] = Math.max(a1,a2);
        }
        else return dp[st][len] = knapsackMem(arr, n, st+1, len, dp);
    }
    */
    public static int knapsackDP(int[] arr, int n, int st, int len){
        if(st > n) return 0;
        int[][] dp = new int[n+1][len+1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= len; j++){
                if(i <= j){
                    int a1 = arr[i-1] + dp[i][j-i];
                    int a2 = dp[i-1][j];
                    dp[i][j] = Math.max(a1, a2);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][len];
    }
}