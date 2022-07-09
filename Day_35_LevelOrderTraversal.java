/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

*/

import java.util.*;

public class Solution {

  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
     ArrayList<Integer> res = new ArrayList<>(); 
      if(root == null) return res;
      
      Queue<BinaryTreeNode> q = new LinkedList<>();
      q.add(root);
      
      while(!q.isEmpty()){
          BinaryTreeNode node = q.poll();
          res.add(node.val);
          if(node.left != null){
              q.add(node.left);
          }
          if(node.right != null){
              q.add(node.right);
          }
      }
     return res; 
  }

}
