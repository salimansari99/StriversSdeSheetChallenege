/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.*;

public class Solution 
{
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0,root));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            if(map.containsKey(p.level)){
                map.get(p.level).add(p.node.data);
            }
            else{
                map.put(p.level, new ArrayList<Integer>());
                map.get(p.level).add(p.node.data);
            }
            if(p.node.left != null) q.add(new Pair(p.level-1, p.node.left));
            if(p.node.right != null) q.add(new Pair(p.level+1, p.node.right));
            
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int key : map.keySet()){
            for(int el : map.get(key)){
                res.add(el);
            }
        }
        return res;
    }
}
class Pair{
    int level;
    TreeNode<Integer> node;
    public Pair(int level, TreeNode<Integer> node){
        this.level = level;
        this.node = node;
    }
}