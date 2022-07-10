/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

************************************************************/

import java.util.*;

public class Solution {
    public static  ArrayList<Integer> traverseBoundary(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.data);
        if(isLeaf(root)) return res;
        addLeft(root, res);
        addLeaf(root,res);
        addRight(root, res);
        return res;
//         for(int el : res){
//             System.out.print(el +" ");
//         }
        
    }
    static void addLeft(TreeNode root, ArrayList<Integer> res){
        
        TreeNode curr = root.left;
        while(curr != null){
            if(isLeaf(curr) == false) res.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    
    static void addLeaf(TreeNode root, ArrayList<Integer> res){
        if(isLeaf(root) == true){
            res.add(root.data);
            return;
        }
        if(root.left != null) addLeaf(root.left, res);
        if(root.right != null) addLeaf(root.right, res); 
    }
    
    static void addRight(TreeNode root, ArrayList<Integer> res){
         
        TreeNode curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(isLeaf(curr) == false) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for(int i = temp.size()-1; i >= 0; i--){
            res.add(temp.get(i));
        }
    }
    
    static boolean isLeaf(TreeNode curr){
        return curr.left == null && curr.right == null;
    } 
}