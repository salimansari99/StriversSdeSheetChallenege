 /************BFS********/
import java.util.*;
public class Solution {
    
    public static String cycleDetection(int[][] edges, int n, int m) {
       
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<Integer>());
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            if(!vis[i]){
                if(bfs(i,adj,vis)) return "Yes";
            }
        }
        return "No";
    }
    public static boolean bfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
       
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(v,-1));
        vis[v] = true;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int nde = p.node;
            int parent = p.parent;
            for(int it : adj.get(nde)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(new Pair(it,nde));
                }
                else if(it != parent) return true;
            }
        }
        return false;
    }
}
class Pair{
    int node;
    int parent;
    public Pair(int _n, int _p){
        node = _n;
        parent = _p;
    }
}


/***********DFS *************/
/*
import java.util.*;
public class Solution {
    
    public static String cycleDetection(int[][] edges, int n, int m) {
       
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<Integer>());
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            if(!vis[i]){
                if(dfs(i,-1,adj,vis)) return "Yes";
            }
        }
        return "No";
    }
    public static boolean dfs(int v, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
       
        vis[v] = true;
        for(int it : adj.get(v)){
            if(vis[it] == false){
                if(dfs(it, v, adj, vis)) return true;
            }
            else if(it != parent) return true;
        }
        return false;
    }
    
}
*/