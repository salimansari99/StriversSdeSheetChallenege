import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
        long mx = Integer.MIN_VALUE;
        long mxend = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            mxend = Math.max(arr[i],mxend+arr[i]);
            mx = Math.max(mx,mxend);
        }
        return mx < 0 ? 0 : mx;
	}

}
