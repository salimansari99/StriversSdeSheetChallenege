public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        long sum = 0, max = 0;
        
        for(int el : time){
            sum += el;
            max = Math.max(el,max);
        }
        
        long lo = max, hi = sum;
        long res = 0;
        while(lo <= hi){
            long mid = lo + (hi - lo)/2;
            
            if(valid(time,n,mid)){
                res = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return res;
    }
    public static boolean valid(int[] time, int n, long mid){
        int count = 1;
        long sum = 0;
        for(int i = 0; i < time.length; i++){
            sum += time[i];
            if(sum > mid){
                count++;
                sum = time[i];
            }
            if(count > n) return false;
        }
        return true;
    }
}