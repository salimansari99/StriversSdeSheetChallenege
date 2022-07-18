public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        
        //return subset(arr, n, k);
        
        //return subsetMem(arr, n, k, new boolean[n+1][k+1]);
        
        return subsetDP(arr, n, k);
        
        
    }
    /*  RECURSION
    public static boolean subset(int[] arr, int n, int k){
        if(n == 0 && k == 0) return true;
        if(n == 0 && k > 0) return false;
        if(n >= 0 && k == 0) return true;
        
        if(arr[n-1] <= k){
            boolean a1 = subset(arr, n-1, k-arr[n-1]);
            boolean a2 = subset(arr, n-1, k);
            return a1 || a2;
        }
        return subset(arr, n-1, k);
    }
    */
    /*  MEMOIZATION
     public static boolean subsetMem(int[] arr, int n, int k, boolean[][] dp){
        if(n == 0 && k == 0) return true;
        if(n == 0 && k > 0) return false;
        if(n >= 0 && k == 0) return true;
        
         if(dp[n][k] == true) return dp[n][k];
        if(arr[n-1] <= k){
            boolean a1 = subsetMem(arr, n-1, k-arr[n-1], dp);
            boolean a2 = subsetMem(arr, n-1, k, dp);
            dp[n][k] = a1 || a2;
            return a1 || a2;
        }
        return dp[n][k] = subsetMem(arr, n-1, k, dp);
    }
    */
    
    public static boolean subsetDP(int[] arr, int n, int k){
        if(n == 0 && k == 0) return true;
        if(n == 0 && k > 0) return false;
        if(n >= 0 && k == 0) return true;
        
        boolean[][] dp = new boolean[n+1][k+1];

        for(int i = 0; i <= n; i++) dp[i][0] = true;
        for(int i = 0; i <= k; i++) dp[0][i] = false;
        dp[0][0] = true;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                 if(arr[i-1] <= j){
                    boolean a1 = dp[i-1][j-arr[i-1]];
                    boolean a2 = dp[i-1][j];
                    dp[i][j] = a1 || a2;
                   }
                  else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][k];
    }
}
