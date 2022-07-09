/*************************************************************

Following is the Binary Tree Node structure:

    class TreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left;
		public BinaryTreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
	  	}
    }

*************************************************************/

public class Solution {
    
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		if(root == null) return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        int ans = left+right;
        int leftdiam = diameterOfBinaryTree(root.left);
        int rightdiam = diameterOfBinaryTree(root.right);
        int max = Math.max(ans, Math.max(leftdiam, rightdiam));
        return max;  
	}
    public static int height(TreeNode<Integer> root){
        if(root == null) return 0;
        
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        if(leftheight <= rightheight){
            return 1 + rightheight;
        }
        else return 1 + leftheight;
    }
}