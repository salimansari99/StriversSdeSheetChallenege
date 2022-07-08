/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/
import java.util.*;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
       List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> ds = new ArrayList<Integer>();
         inOrder(root, ds);
        res.add(ds);
        ds = new ArrayList<Integer>();
        preOrder(root, ds);
        res.add(ds);
        ds = new ArrayList<>();
        postOrder(root,ds);
        res.add(ds);
        return res;
    }
    public static void inOrder(BinaryTreeNode<Integer> root, List<Integer> ds){
        if(root == null) return;
        
        inOrder(root.left,ds);
        ds.add(root.data);
        inOrder(root.right,ds);
    }
     public static void preOrder(BinaryTreeNode<Integer> root, List<Integer> ds){
        if(root == null) return;
        ds.add(root.data);
        preOrder(root.left,ds);
        preOrder(root.right,ds);
     }
    
    public static void postOrder(BinaryTreeNode<Integer> root, List<Integer> ds){
        if(root == null) return;

        postOrder(root.left,ds);
        postOrder(root.right,ds);
        ds.add(root.data);
     }
}
