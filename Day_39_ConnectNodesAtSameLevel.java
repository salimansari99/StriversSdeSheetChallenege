/*
    ----------------- Binary Tree node class for reference -----------------

    class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;
	    public BinaryTreeNode<T> next;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	        next = null;
	    }
	};

*/
//import java.util.Queue;
import java.util.*;
public class Solution {
	public static void connectNodes(BinaryTreeNode<Integer> root) {
    	if(root == null) return;
        
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            if(n == 0) break;
            
            for(int i = 0; i < n; i++){
               BinaryTreeNode<Integer> front = q.poll();
               if(i<n-1){
                front.next = q.peek();
                }
                else front.next = null;
               if(front.left != null){
                  q.add(front.left);
                }
               if(front.right != null){
                  q.add(front.right);
                }
            }
        }
	}
}
