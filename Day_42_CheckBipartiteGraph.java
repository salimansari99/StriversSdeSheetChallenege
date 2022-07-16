/************BFS*************/
import java.util.*;

public class Solution {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < edges.size(); i++) adj.add(new ArrayList<Integer>());
        
        for(int i = 0; i < edges.size(); i++){
            for(int j = 0; j < edges.get(i).size(); j++){
                if(edges.get(i).get(j) == 1){
                    adj.get(j).add(i);
                    adj.get(i).add(j);
                }
            }
        }
        
        boolean[] vis = new boolean[edges.size()];
        for(int i = 0; i < edges.size(); i++){
            if(!vis[i]){
                if(!bfs(i, adj, vis)) return false;
            }
        }
        return true;
    }
    public static boolean bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[adj.size()];
        q.add(node);
        vis[node] = true;
        color[node] = 1;
        
        while(!q.isEmpty()){
            int nde = q.poll();
            for(int it : adj.get(nde)){
                if(!vis[it]){
                    vis[it] = true;
                    color[it] = 1 - color[nde];
                    q.add(it);
                }
                else if(color[it] == color[nde]) return false;
            }
        }
        return true;
    }
}

/************DFS********/
/*
import java.util.*;

public class Solution {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < edges.size(); i++) adj.add(new ArrayList<Integer>());
        
        for(int i = 0; i < edges.size(); i++){
            for(int j = 0; j < edges.get(i).size(); j++){
                if(edges.get(i).get(j) == 1){
                    adj.get(j).add(i);
                    adj.get(i).add(j);
                }
            }
        }
        
        boolean[] vis = new boolean[edges.size()];
        int[] color = new int[edges.size()];
        Arrays.fill(color, -1);
        for(int i = 0; i < edges.size(); i++){
            if(!vis[i]){
                if(!dfs(i, adj, vis, color)) return false;
            }
        }
        return true;
    }
    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] color){
       if(color[node] == -1) color[node] = 1;
        vis[node] = true;
        //color[node] = color;
            for(int it : adj.get(node)){
                if(!vis[it]){
                    color[it] = 1 - color[node];
                    if(!dfs(it, adj, vis, color)) return false;
                }
                else if(color[it] == color[node]) return false;
            }
        
        return true;
    }
}
*/