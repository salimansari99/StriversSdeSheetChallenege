
public class Solution {

	public static int lcs(String s, String t) {
		
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        return lcsDP(s, t, n, m, dp);
    }
    /* Recursion
    public static int lcsRec(String s1, String s2, int n, int m){
        if(n == 0 || m == 0) return 0;
        
        if(s1.charAt(n-1) == s2.charAt(m-1))
            return 1 + lcsRec(s1, s2, n-1, m-1);
        else{
            int a1 = lcsRec(s1, s2, n, m-1);
            int a2 = lcsRec(s1, s2, n-1, m);
            return Math.max(a1, a2);
        }
    }
    */
    
    /* Memoization
     public static int lcsMem(String s1, String s2, int n, int m, int[][] dp){
        if(n == 0 || m == 0) return 0;
        if(dp[n][m] != 0) return dp[n][m];
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            dp[n][m] = 1 + lcsMem(s1, s2, n-1, m-1, dp);
            return dp[n][m];
        }
        else{
            int a1 = lcsMem(s1, s2, n, m-1, dp);
            int a2 = lcsMem(s1, s2, n-1, m, dp);
            return dp[n][m] = Math.max(a1, a2);
        }
    }
    */
    /******** Tabulation *********/
      public static int lcsDP(String s1, String s2, int n, int m, int[][] dp){
        if(n == 0 || m == 0) return 0;
        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        for(int i = 0; i <= m; i++) dp[0][i] = 0;  
          
       
          for(int i = 1; i <= n; i++){
              for(int j = 1; j <= m; j++){
                 if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                 }
                 else{
                      int a1 = dp[i-1][j];
                      int a2 = dp[i][j-1];
                      dp[i][j] = Math.max(a1, a2);
                     } 
               }
           }
        return dp[n][m];
    }

}