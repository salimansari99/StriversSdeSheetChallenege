import java.util.*;

public class Solution {

	public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0, j = 0, n = arr.size();
        ArrayList<Integer> res = new ArrayList<>();
        while(j < n){
            map.put(arr.get(j), map.getOrDefault(arr.get(j), 0)+1);
            if(j-i+1 < k) j++;
            else if(j-i+1 == k){
                res.add(map.size());
                if(map.get(arr.get(i)) == 1) map.remove(arr.get(i));
                else map.put(arr.get(i), map.get(arr.get(i))-1);
                i++;
                j++;
            }
        }
        return res;
	}
}
