import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getTrappedWater(long[] arr, int n) {
        
        long[] left = new long[n];
        left[0] = arr[0];
        
        for(int i = 1; i < n; i++){
            if(left[i-1] <= arr[i]) left[i] = arr[i];
            else left[i] = left[i-1];
        }
        
        long[] right = new long[n];
        right[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            if(right[i+1] <= arr[i]) right[i] = arr[i];
            else right[i] = right[i+1];
        }
        
        long area = 0;
        for(int i = 0; i < n; i++){
            long min = Math.min(left[i], right[i]);
            area += min - arr[i];
        }
        return area;
    }
}
