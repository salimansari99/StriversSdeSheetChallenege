import java.util.*;
public class Solution {
    public static void findtopo(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st){
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                findtopo(it, adj, vis, st);
            }
        }
        st.push(node);
    }
    
    public static void dfs(int node, List<List<Integer>> transpose, boolean[] vis, List<Integer> ds){
        vis[node] = true;
        ds.add(node);
        for(int it : transpose.get(node)){
            if(!vis[it]){
            dfs(it, transpose, vis, ds);
          }
        }
    }

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<Integer>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        // Find Topological sort
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                findtopo(i,adj, vis, st);
            }
        }
        
        // Transpose of graph
        List<List<Integer>> transpose = new ArrayList<>();
        for(int i = 0; i < n; i++) transpose.add(new ArrayList<Integer>());
        for(int i = 0; i < n; i++){
            vis[i] = false;
            for(int it : adj.get(i)){
                transpose.get(it).add(i);
            }
        }
        
        // dfs traversal
        List<List<Integer>> res = new ArrayList<>();
        while(st.size()>0){
            int node = st.pop();
            if(!vis[node]){
                List<Integer> ds = new ArrayList<>();
                dfs(node, transpose, vis, ds);
                res.add(ds);
            }
        }
        return res;
    }
}