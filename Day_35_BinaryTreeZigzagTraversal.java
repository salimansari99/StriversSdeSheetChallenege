/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/
import java.util.*;
public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		// Write your code here!
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        int zigzag = 0;
        Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()){
            int n = q.size();
            if(n == 0) break;
           
            while(n-->0){
                BinaryTreeNode<Integer> node = q.poll();
                if(zigzag==1){
                    st.push(node.data);
                }
                else res.add(node.data);
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            zigzag = 1 - zigzag;
            while(!st.isEmpty()){
                res.add(st.pop());
            }
        }
        return res;

	}
}