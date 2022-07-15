import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++) adj.add(new ArrayList<>());
        
        for(ArrayList<Integer> al : edges){
           adj.get(al.get(0)).add(al.get(1));
            adj.get(al.get(1)).add(al.get(0));
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[v];
        for(int i = 0; i < v; i++){
            if(vis[i] == false){
                ArrayList<Integer> ds = new ArrayList<>();
                dfs(i, adj, vis, ds);
                res.add(new ArrayList<>(ds));
            }
        }
        return res;
    }
    public static ArrayList<Integer> dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ds){
        ds.add(node);
        vis[node] = true;
        for(Integer it : adj.get(node)){
            if(vis[it] == false){
                dfs(it, adj, vis, ds);
            }
        }
        return ds;
    }
}