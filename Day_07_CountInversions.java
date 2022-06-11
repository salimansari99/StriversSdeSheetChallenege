import java.util.*;
public class Solution {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        //Brute Force
        /*
		int inversion = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i]>arr[j]) inversion++;
            }
        }
		return (long)inversion;
        */
//         long[] res = new long[1];
//         res[0] = 0;
        return mergeSort(arr,0,n-1);
        //return res[0];
    }
    public static long mergeSort(long[] arr, int lo, int hi){
        if(lo>=hi) return 0;
        
        int mid = (lo+hi)/2;
        long inv = mergeSort(arr,lo,mid);
        inv += mergeSort(arr,mid+1,hi);
        inv += merge(arr,lo,mid,hi);
        return inv;
    }
    
    public static long merge(long[] arr ,int lo, int mid, int hi){
        
        int j = mid+1;
        int cnt = 0;
        for(int i = lo; i <=mid; i++){
            while(j <=hi && arr[i]>arr[j] ) j++;
            
            cnt += (j-(mid+1));
        }
        
        ArrayList<Long> temp  = new ArrayList<>();
        
        int left = lo, right = mid+1;
        while(left<=mid && right <= hi){
            if(arr[left]<=arr[right]){
                temp.add(arr[left++]);
            }
            else temp.add(arr[right++]);
        }
        while(left<=mid) temp.add(arr[left++]);
        
        while(right<=hi) temp.add(arr[right++]);
        
        for(int i = lo; i <= hi; i++){
            arr[i] = temp.get(i-lo);
        }
        return cnt;
        
    }
}