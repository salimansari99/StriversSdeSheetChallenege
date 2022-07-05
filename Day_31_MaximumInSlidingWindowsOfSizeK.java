
import java.util.*;

public class Solution 
{

	public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) 
	{
		ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0, n = nums.size();
        ArrayList<Integer> temp = new ArrayList<>();
  
        while(j < n){
            
            while(temp.size() > 0 && temp.get(temp.size() - 1) < nums.get(j)) temp.remove(temp.size()-1);
            temp.add(nums.get(j));
            if(j - i + 1 < k){
                j++;
            }
            else if(j - i + 1 == k){
                res.add(temp.get(0));
                if(temp.get(0) == nums.get(i)) temp.remove(0);
                i++;
                j++;
            }
        }
        return res;
	}
}