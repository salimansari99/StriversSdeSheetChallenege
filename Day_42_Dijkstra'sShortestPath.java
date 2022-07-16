import java.util.*;
public class Solution {
	
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
		
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for(int i = 0; i < vertices; i++) adj.add(new ArrayList<Node>());
        
        for(ArrayList<Integer> edge : vec){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.get(u).add(new Node(v, w));
            adj.get(v).add(new Node(u, w));
        }
        
        ArrayList<Integer> dist = new ArrayList<>();
        for(int i = 0; i < vertices; i++) dist.add(Integer.MAX_VALUE);
        
        dist.set(source,0);
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return n1.getW() - n2.getW();
            }
        });
        pq.offer(new Node(source, 0));
        
        while(pq.size() > 0){
            int u = pq.peek().v;
            int w = pq.peek().wt;
            pq.poll();
            
            for(Node it : adj.get(u)){
                if(dist.get(u) + it.getW() < dist.get(it.getV())){
                    dist.set(it.getV(), dist.get(u) + it.getW());
                    pq.offer(new Node(it.getV(), dist.get(u) + it.getW()));
                }
            }
        }
        return dist;   
	}
}
class Node{
    int v;
    int wt;
    public Node(int _v, int w){
        v = _v;
        wt = w;
    }
    int getV(){
        return v;
    }
    int getW(){
        return wt;
    }
}