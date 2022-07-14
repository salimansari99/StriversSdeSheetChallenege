import java.util.*;
public class Solution {

	static int kthLargest(ArrayList<Integer> arr, int size, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int el : arr){
            pq.add(el);
            if(pq.size() > K) pq.poll();
        }
        return pq.peek();
    }
}
