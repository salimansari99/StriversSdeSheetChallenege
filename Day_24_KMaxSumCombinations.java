import java.util.*;
public class Solution{
	public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
               int sum = a.get(i)+b.get(j);
                if(pq.size() < k) pq.add(sum);
                else if(pq.peek() < sum){
                        pq.poll();
                        pq.add(sum);
                    }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(0,pq.poll());
        }
        return res;
	}
}