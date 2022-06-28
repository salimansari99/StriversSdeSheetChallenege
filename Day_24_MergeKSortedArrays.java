import java.util.*;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(ArrayList<Integer> al : kArrays){
            for(int el : al) pq.add(el);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;
	}
}
