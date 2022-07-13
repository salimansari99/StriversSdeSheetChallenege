/*************************************************************
    Following is the Binary Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.*;

public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		
        ArrayList<Integer> res = new ArrayList<>();
        int successor = -1;
        BinaryTreeNode<Integer> curr = root;  
        while(curr != null){
            
            if(curr.data <= key){
                curr = curr.right;
            }
            else{
                successor = curr.data;
                //break;
                curr = curr.left;
            }
        }
        int predecessor = -1;
        curr = root; 
        while(curr != null){
            
            if(curr.data >= key){
                curr = curr.left;
            }
            else{
                predecessor = curr.data;
               
                curr = curr.right;
            }
        }
        res.add(predecessor);
        res.add(successor);
        
        return res;
	}
}