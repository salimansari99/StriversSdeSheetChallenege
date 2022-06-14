import java.util.*;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

        HashMap<Integer,Integer> map = new HashMap<>();
        
        map.put(0,-1);
        int sum = 0, mx = 0;
        for(int i = 0; i < arr.size(); i++){
            sum += arr.get(i);
            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                mx = Math.max(mx, len);
            }
            else map.put(sum,i);   
        }
        return mx;
	}
}