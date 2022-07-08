/*
    
    Following is the Binary Tree node structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.data = val;
            this.left = left;
            this.right = right;
        }
    }

*/
import java.util.*;
public class Solution {
    public static List < Integer > getPostOrderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        postOrder(root,res);
        return res;
    }
    public static void postOrder(TreeNode root, List<Integer> res){
        if(root == null) return;
        
        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.data);
    }
}