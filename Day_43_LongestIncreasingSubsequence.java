import java.util.*;
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {
		int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(arr[0]);
        int len = 1;
        
        for(int i = 1; i < n; i++){
            if(res.get(len-1) < arr[i]){
                res.add(arr[i]);
                len++;
            }
            else{
                int ind = Collections.binarySearch(res, arr[i]);
                if(ind < 0){
                    int realInd = (ind+1)*(-1);
                    if(realInd > (len-1)){
                        res.add(arr[i]);
                        len++;
                    }
                    else res.set(realInd, arr[i]);
                }
            }
        }
        return len;
    }
}

/*

public class Solution {

    public static int longestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        
        for(int i = 0; i < n; i++) dp[i] = 1;
        int mx = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
                mx = Math.max(dp[i], mx);
            }
        }
        return mx;
    }

}
*/