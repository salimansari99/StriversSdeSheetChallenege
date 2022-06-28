import java.util.*;
public class Solution {

	public static int[] KMostFrequent(int n, int k, int[] arr) {
		
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int el : arr){
            map.put(el, map.getOrDefault(el,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p1.val - p2.val;
            }
        });
        
        for(int key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
            if(pq.size() > k) pq.poll();
        }
        
        int[] res = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            res[i++] = pq.poll().key;
        }
        Arrays.sort(res);
        return res;
	}
}
class Pair{
    int key;
    int val;
    public Pair(int key, int val){
        this.key = key;
        this.val = val;
    }
}
