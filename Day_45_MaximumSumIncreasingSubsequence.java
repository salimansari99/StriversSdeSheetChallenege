import java.util.ArrayList;

public class Solution {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        
        int[] dp = new int[n];
        int omax = 0;
        for(int i =0; i < n; i++){
            int mx = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++){
                if(rack.get(j) < rack.get(i)){
                    if(mx == Integer.MIN_VALUE) mx = rack.get(j);
                    else mx = Math.max(mx, dp[j]);
                }
            }
            if(mx == Integer.MIN_VALUE) dp[i] = rack.get(i);
            else dp[i] = mx + rack.get(i);
            
            if(dp[i] > omax) omax = dp[i];
        }
        return omax;
    }
}