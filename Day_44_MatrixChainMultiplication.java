public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		int i = 1, j = arr.length-1;
        if(i >= j) return 0; 
        int[][] dp = new int[101][101];
        return solve(arr, i, j, dp);
	}
    public static int solve(int[] arr, int i, int j, int[][] dp){
        if(i >= j) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        
        int mx = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int temp = solve(arr, i, k, dp) + solve(arr, k+1, j, dp) + arr[i-1]*arr[k]*arr[j];
            if(temp < mx) mx = temp;
        }
        return dp[i][j] = mx;
    }
}
