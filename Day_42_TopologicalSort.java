/**************KAHN'S ALGORITHM******/
import java.util.*;
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < v; i++) adj.add(new ArrayList<Integer>());
        
        for(ArrayList<Integer> edge : edges){
            adj.get(edge.get(0)).add(edge.get(1));
        }
        
        boolean[] vis = new boolean[v];
        ArrayList<Integer> res = new ArrayList<>();
        
        kahnAlgo(v, adj, vis, res);  
        return res;
    }
    public static void kahnAlgo(int n, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> res){
        
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int it : adj.get(i))
                indegree[it]++;
        }
        
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()){
            Integer nde = q.poll();
            res.add(nde);
            for(int it : adj.get(nde)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
    }
}

/*************DFS***********/
/*
import java.util.*;
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < v; i++) adj.add(new ArrayList<Integer>());
        
        for(ArrayList<Integer> edge : edges){
            adj.get(edge.get(0)).add(edge.get(1));
        }
        
        boolean[] vis = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < v; i++){
            if(!vis[i]){
                dfsTopo(i, adj, vis, st);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!st.isEmpty()) res.add(st.pop());
        return res;
    }
    public static void dfsTopo(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st){
        vis[node] = true;
        
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfsTopo(it, adj, vis, st);
            }
        }
        st.push(node);
    }
}
*/
