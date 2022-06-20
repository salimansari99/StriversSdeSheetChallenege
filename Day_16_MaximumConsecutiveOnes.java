import java.util.ArrayList;

public class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		
        int i = 0, j = 0;
        int flip = 0, mx = 0;
        while(j < n){
            if(arr.get(j)==1) j++;
            else{
                if(flip < k){
                    flip++;
                    j++;
                }
                else{
                    while(flip >= k){
                        if(arr.get(i)==0) flip--;
                        i++;
                    }
                }
            }
            mx = Math.max(mx,j-i);
        }
        return mx;
	}
}