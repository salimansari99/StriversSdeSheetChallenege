import java.util.*;
public class Solution {
	public static ArrayList<Integer> BFS(int vertex, int edges[][]){
		
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<vertex; i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<edges[0].length;i++){
            adj.get(edges[0][i]).add(edges[1][i]);
            adj.get(edges[1][i]).add(edges[0][i]);
        }
        
        for(int i=0;i<vertex;i++)
            Collections.sort(adj.get(i));
        
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[vertex];
        for(int i = 0; i < vertex; i++){
            if(!vis[i]){
                bfs(i,adj,vis,res);
            }
        }
        return res;
	}
    public static void bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> res){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
       
        while(!q.isEmpty()){
            Integer nde = q.poll();
            res.add(nde);
            for(Integer it : adj.get(nde)){
                if(!vis[it]){
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
    }
}

