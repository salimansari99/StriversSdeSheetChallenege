
public class Solution {

    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if(n == 0 && m == 0) return 0;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) dp[i][0] = i;
        for(int i = 0; i <= m; i++) dp[0][i] = i;
        return editDistDP(str1, str2, n, m,dp);
    }
    public static int editDist(String s1, String s2, int n, int m){
        if(n == 0) return m;
        if(m == 0) return n;
        
        if(s1.charAt(n-1) == s2.charAt(m-1)){
           return editDist(s1, s2, n-1, m-1);
        }
        else{
            int a1 = editDist(s1, s2, n, m-1); //delete
            int a2 = editDist(s1, s2, n-1, m); //insert
            int a3 = editDist(s1, s2, n-1, m-1); //replace
            int ans = Math.min(a1, Math.min(a2, a3));
            return 1 + ans;
        }
    }
    
     public static int editDistMem(String s1, String s2, int n, int m, int[][] dp){
        if(n == 0) return m;
        if(m == 0) return n;
        if(dp[n][m] != 0) return dp[n][m];
        if(s1.charAt(n-1) == s2.charAt(m-1)){
           return dp[n][m] = editDistMem(s1, s2, n-1, m-1, dp);
        }
        else{
            int a1 = editDistMem(s1, s2, n, m-1, dp); //delete
            int a2 = editDistMem(s1, s2, n-1, m, dp); //insert
            int a3 = editDistMem(s1, s2, n-1, m-1, dp); //replace
            int ans = Math.min(a1, Math.min(a2, a3));
            return dp[n][m] = 1 + ans;
        }
    }
    
    public static int editDistDP(String s1, String s2, int n, int m, int[][] dp){
        if(n == 0) return m;
        if(m == 0) return n;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                 if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                   }
                 else{
                       int a1 = dp[i][j-1]; //delete
                       int a2 = dp[i-1][j]; //insert
                       int a3 = dp[i-1][j-1]; //replace
                       int ans = Math.min(a1, Math.min(a2, a3));
                       dp[i][j] = 1 + ans;
                     }
                }
           }
        return dp[n][m];
    }
}