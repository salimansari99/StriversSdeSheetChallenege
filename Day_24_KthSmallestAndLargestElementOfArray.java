import java.util.*;


public class Solution {
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		ArrayList<Integer> res = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        
        for(int el : arr){
            pq.add(el);
            if(pq.size() > k) pq.poll();
        }
        res.add(pq.peek());
          pq = new PriorityQueue<>((a,b)->(a-b));
        
        for(int el : arr){
            pq.add(el);
            if(pq.size() > k) pq.poll();
        }
        res.add(pq.peek());
        return res;
	}
}
