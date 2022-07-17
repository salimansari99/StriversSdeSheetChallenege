
public class Solution {

	public static long countWaysToMakeChange(int denominations[], int value){
        
        int n = denominations.length;
        /*
       return coinChange(denominations, value, n);
       */
        /*
        long[][] dp = new long[n+1][value+1];
        for(int i = 0; i <= n; i++) dp[i][0] = 1;
        for(int i = 0; i <= value; i++) dp[0][i] = 0;
        dp[0][0] = 1;
        return coinChangeMem(denominations, value, n, dp);
        */
        
        return coinChangeDP(denominations, value, n);
        
	}
    /*
    public static long coinChange(int[] arr, int W, int n){
        if(n == 0 && W == 0) return 1;
        if(n == 0 && W > 0) return 0;
        if(n >= 0 && W == 0) return 1;
        
        if(arr[n-1] <= W){
            long a1 = coinChange(arr, W-arr[n-1], n);
            long a2 = coinChange(arr, W, n-1);
            return a1 + a2;
        }
        else return coinChange(arr, W, n-1);
    }
	*/
    /*
     public static long coinChangeMem(int[] arr, int W, int n, long[][] dp){
        if(n == 0 && W == 0) return 1;
        if(n == 0 && W > 0) return 0;
        if(n >= 0 && W == 0) return 1;
        if(dp[n][W] != 0) return dp[n][W];
        if(arr[n-1] <= W){
            long a1 = coinChangeMem(arr, W-arr[n-1], n, dp);
            long a2 = coinChangeMem(arr, W, n-1, dp);
            return dp[n][W] = a1 + a2;
        }
        else return dp[n][W] = coinChangeMem(arr, W, n-1, dp);
    }
    */
    public static long coinChangeDP(int[] arr, int W, int n){
        if(n == 0 && W == 0) return 1;
        if(n == 0 && W > 0) return 0;
        
        long[][] dp = new long[n+1][W+1];
        
        for(int i = 0; i <= n; i++) dp[i][0] = 1;
        for(int i = 0; i <= W; i++) dp[0][i] = 0;
        dp[0][0] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                 if(arr[i-1] <= j){
                    long a1 = dp[i][j-arr[i-1]];
                    long a2 = dp[i-1][j];
                    dp[i][j] = a1 + a2;
                   }
                 else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][W];
    }
}