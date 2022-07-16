import java.util.*;
public class Solution {
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        
        ArrayList<Node> adj = new ArrayList<>();
        
        for(ArrayList<Integer> edge : graph){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.add(new Node(u,v,w));
            adj.add(new Node(v,u,w));
        }
        Collections.sort(adj, new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return n1.getW() - n2.getW();
            }
        });
        
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        int cost = 0;
        for(Node edge : adj){
            int u = edge.getU();
            int v = edge.getV();
            int w = edge.getW();
            if(findparent(u,parent) != findparent(v,parent)){
                cost += w;
                union(u,v,parent, rank);
            }
        }
        return cost;
    }
    public static int findparent(int u, int[] parent){
        if(parent[u] == u) return u;
        return parent[u] = findparent(parent[u], parent);
    }
    public static void union(int u, int v, int[] parent, int[] rank){
        u = findparent(u,parent);
        v = findparent(v, parent);
        
        if(rank[u] < rank[v])
            parent[u] = v;
        else if(rank[u] > rank[v])
            parent[v] = u;
        else{
            parent[u] = v;
            rank[v]++;
        }
    }
}
class Node{
    int u;
    int v;
    int w;
    public Node(int _u, int _v, int _w){
        u = _u;
        v = _v;
        w = _w;
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