/**********DFS***********/
import java.util.ArrayList;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    
      
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for(int i = 0; i <= n; i++) adj.add(new ArrayList<Integer>());
      
      for(ArrayList<Integer> edge : edges){
          adj.get(edge.get(0)).add(edge.get(1));
      }
      
      boolean[] vis = new boolean[n+1];
      for(int i = 1; i <= n; i++){
          if(!vis[i]){
              if(dfs(i,adj, vis, new boolean[n+1])) return true;
          }
      }
      return false;  
  }
    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] dfsvis){
        
        vis[node] = true;
        dfsvis[node] = true;
        
        for(int it : adj.get(node)){
            if(vis[it] == false){
                if(dfs(it, adj, vis, dfsvis)) return true;
            }
            else if(dfsvis[it] == true) return true;
        }
        dfsvis[node] = false;
        return false;
    }
}
 /***************BFS/ KAHN'S ALGORITHM***********/
/*
import java.util.*;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    
      
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for(int i = 0; i <= n; i++) adj.add(new ArrayList<Integer>());
      
      for(ArrayList<Integer> edge : edges){
          adj.get(edge.get(0)).add(edge.get(1));
      }
      
      boolean[] vis = new boolean[n+1];
      
       return kahnAlgo(n, adj, vis);
  }
  public static boolean kahnAlgo(int n, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
      
      Queue<Integer> q = new LinkedList<>();
      int[] indegree = new int[n+1];
      for(int i = 1; i <= n; i++){
          for(int it : adj.get(i)){
              indegree[it]++;
          }
      }
      
      for(int i = 1; i <= n; i++){
          if(indegree[i] == 0)
             q.add(i);
      }
      int cnt = 0;
      while(!q.isEmpty()){
          Integer node = q.poll();
          cnt++;
          
          for(int it : adj.get(node)){
              indegree[it]--;
              if(indegree[it] == 0) q.add(it);
          }
      }
      return cnt == n ? false : true;
  }
}
*/