/*****************************************************************

    Following is the representation for the Binary Tree Node:

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

****************************************************************/

public class Solution {

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        if(root == null) return true;
        
        return symmetric(root,root);
    }
    public static boolean symmetric(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right){
        if(left == null || right == null) return left == right;
        
        return (left.data.equals(right.data)) && symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
}