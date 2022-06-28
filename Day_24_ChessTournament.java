import java.util.*;
public class Solution {

    public static int chessTournament(int[] positions, int n,  int c) 
	{
        Arrays.sort(positions);
        int lo = 1, hi = positions[n-1];
        int res = -1;
        while(lo <= hi){
            int mid = (lo+hi)>>1;
            
            if(valid(positions,mid,c)){
                res = mid;
                lo = mid + 1;
            }
            else hi = mid -1;
        }
        return res;
    }
    public static boolean valid(int[] arr, int max, int player){
        int cnt = 1;
        int first = arr[0];
        for(int i = 1;i < arr.length; i++){
            if(arr[i] - first >= max){
                first = arr[i];
                cnt++;
            }
            if(cnt == player) return true;
            
        }
        return false;
    }

}