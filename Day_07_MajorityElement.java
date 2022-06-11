import java.util.* ;
import java.io.*; 
public class Solution {
	public static int findMajority(int[] arr, int n) {
		HashMap<Integer,Integer> map = new HashMap<>();
        for(int el : arr) map.put(el,map.getOrDefault(el,0)+1);
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node n1,Node n2){
                return n2.val - n1.val;
            }
        });
        
        for(int key : map.keySet()){
            pq.add(new Node(map.get(key),key));
        }
        Node node = pq.poll();
        if(node.val>Math.floor(n/2)) return node.key;
        return -1;
        
	}
}
class Node{
    int val;
     int key;
    public Node(int val,int key){
        this.val = val;
        this.key = key;
    }
}