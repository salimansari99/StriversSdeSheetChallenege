/*************************************************************
    
    Following is the Binary Tree node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }
    }

*************************************************************/
import java.util.*;
public class Solution {
	public static boolean pairSumBst(BinaryTreeNode root, int k) {
        if(root == null) return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        return pair(root, k, map);
	}
    public static boolean pair(BinaryTreeNode root, int k, HashMap<Integer,Integer> map){
        if(root == null) return false;
        
        if(map.containsKey(k - root.data)) return true;
        map.put(root.data,map.getOrDefault(root.data,0)+1);
        return pair(root.left, k, map) || pair(root.right, k, map);
    }
}

