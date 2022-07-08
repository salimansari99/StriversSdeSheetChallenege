/************************************************************

    Following is the TreeNode class structure:

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

************************************************************/
import java.util.*;
public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            if(!map.containsKey(p.level)){
                map.put(p.level, p.node.val);
            }
            
            if(p.node.left != null){
                q.add(new Pair(p.level-1, p.node.left));
            }
            if(p.node.right != null){
                q.add(new Pair(p.level+1, p.node.right));
            }
        }
        
        for(int key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
	}
}
class Pair{
    int level;
    BinaryTreeNode node;
    public Pair(int level, BinaryTreeNode node){
        this.level = level;
        this.node = node;
    }
}
