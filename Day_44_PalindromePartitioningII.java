public class Solution {

	public static int palindromePartitioning(String str) {
	    int i = 0;
        int j = str.length()-1;
        if(i >= j) return 0;
        int[][] dp = new int[101][101];
        return solve(str, i, j, dp);
	}
    public static int solve(String s, int i, int j, int[][] dp){
        if(i >= j) return 0;
        
        if(palindrome(s, i, j)) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        int mn = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int temp = 1 + solve(s, i, k, dp)+solve(s, k+1, j, dp);
            if(temp < mn) mn = temp;        
        }
        return dp[i][j] = mn;
    }
    
    public static boolean palindrome(String s, int i, int j){
        
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
