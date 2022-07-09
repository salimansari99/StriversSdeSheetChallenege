/*************************************************************

Following is the Binary Tree node structure

class BinaryTreeNode<T> 
{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

*************************************************************/
public class Solution {

	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
		
        if(root == null) return true;
        
        int left = height(root.left);
        int right = height(root.right);
        
        int diff = Math.abs(left-right);
        if(diff > 1) return false;
        return isBalancedBT(root.left) && isBalancedBT(root.right);  
	}
    public static int height(BinaryTreeNode<Integer> root){
        if(root == null) return 0;
        
        int lh = height(root.left);
        int rh = height(root.right);
        return lh < rh ? rh+1 : lh+1;
    }
}
