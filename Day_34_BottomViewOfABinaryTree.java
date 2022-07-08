/*********************************************

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

*********************************************/

import java.util.*;
public class Solution {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
         
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        Map<Integer,Integer> map = new TreeMap<>();
        //map.put(0,root.val);
        bfs(root,0,map);
        for(int key : map.keySet()){
           // System.out.println(key +" "+ map.get(key));
            res.add(map.get(key));
        }
        return res;
    }
    public static void bfs(BinaryTreeNode root, int i,  Map<Integer,Integer> map){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        map.put(0,root.val);
        
        while(!q.isEmpty()){
           Pair p  = q.poll();
            map.put(p.level, p.node.val);
            if(p.node.left != null){
                q.add(new Pair(p.level-1, p.node.left));
            }
             if(p.node.right != null){
                q.add(new Pair(p.level+1, p.node.right));
            }
        }
    }
  static  class Pair{
        int level;
        BinaryTreeNode node;
        public Pair(int level, BinaryTreeNode node){
            this.level = level;
            this.node = node;
        }
    }
}
