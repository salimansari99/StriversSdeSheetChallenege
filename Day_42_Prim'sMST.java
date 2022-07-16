import java.util.*;

public class Solution 
{
    public static int findMin(boolean[] vis, int[] dist){
        int minvertex = -1;
        for(int i =1; i < vis.length; i++){
            if(!vis[i] && (minvertex == -1 || dist[i] < dist[minvertex])){
                minvertex = i;
            }
        }
        return minvertex;
    }
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
       ArrayList<ArrayList<Node>> adj = new ArrayList<>(); 
        
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<Node>());
        
        for(ArrayList<Integer> edge : g){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.get(u).add(new Node(v,w));
            adj.get(v).add(new Node(u,w));
        }
        
        int[] dist = new int[n+1];
        boolean[] vis = new boolean[n+1];
        int[] parent = new int[n+1];
        for(int i = 0; i <= n; i++){
            parent[i] = -1;
            vis[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
          
        for(int i = 1; i <= n; i++){
            int u = findMin(vis, dist);
            vis[u] = true;
            for(Node it : adj.get(u)){
                if(vis[it.getV()] == false && it.getW() < dist[it.getV()]){
                    parent[it.getV()] = u;
                    dist[it.getV()] = it.getW();
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i = 2; i <= n; i++){
            ArrayList<Integer> edge = new ArrayList<>();
            if(i < parent[i]){
                edge.add(i);
                edge.add(parent[i]);
                edge.add(dist[i]);
            //res.add(edge);
             }
            else{
                 
                edge.add(parent[i]);
                edge.add(i);
                edge.add(dist[i]);
            //res.add(edge);
            }
            res.add(edge);
        }
        
       return res; 
        
    }
}
class Node{
    int v;
    int wt;
    public Node(int _v, int _wt){
        v = _v;
        wt = _wt;
    }
    int getV(){
        return v;
    }
    int getW(){
        return wt;
    }
}