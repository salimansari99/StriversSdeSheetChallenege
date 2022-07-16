import java.util.*;
public class Solution {
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
     
        ArrayList<Node> adj = new ArrayList<>();
        for(ArrayList<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.add(new Node(u,v,w));
        }
        int[] dist = new int[n+1];
        for(int i = 0; i <= n; i++) dist[i] = 1000000000;
        dist[src] = 0;
        for(int i = 1; i <= n-1; i++){
            for(Node node : adj){
                int u = node.getU();
                int v = node.getV();
                int w = node.getW();
               int wt = dist[u] == 1000000000 ? 1000000000 : w + dist[u];
                dist[v] = Math.min(wt, dist[v]);
            }
        }
        return dist[dest];
    }  
}
class Node{
    private int u;
    private int v;
    private int w;
    public Node(int u, int v, int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }
    int getU(){
        return u;
    }
    int getV(){
        return v;
    }
    int getW(){
        return w;
    }
    
}