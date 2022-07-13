/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

 *************************************************************/

public class Solution {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
       if(root == null) return true;
        
        /* Method 1
        int leftmax = maximum(root.left);
        int rightmin = minimum(root.right);
        if(leftmax > root.data || rightmin < root.data) return false;
        return validateBST(root.left) && validateBST(root.right);
        */
        
         //Method 2
         return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
         
        
        /* Method 3
        BSTReturn bst = validBST(root);
        return bst.isbst;
        */
    }
    /* method 1
     public static int maximum(BinaryTreeNode<Integer> root){
        if(root == null) return Integer.MIN_VALUE;
        
        int left = maximum(root.left);
        int right = maximum(root.right);
        return Math.max(root.data, Math.max(left,right));
    }
    public static int minimum(BinaryTreeNode<Integer> root){
        if(root == null) return Integer.MAX_VALUE;
        
        int left = minimum(root.left);
        int right = minimum(root.right);
        return Math.min(root.data, Math.min(left, right));
    }
    */
    
     //Method 2
     public static boolean isBST(BinaryTreeNode<Integer> root, int min, int max){
        if(root == null) return true;
        
        if(root.data < min || root.data > max) return false;
        
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }
    
    
    /* Method 3
    public static BSTReturn validBST(BinaryTreeNode<Integer> root){
        if(root == null){
            BSTReturn node = new BSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            return node;
        }
        
        BSTReturn left = validBST(root.left);
        BSTReturn right = validBST(root.right);
        
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));
        boolean isbst = true;
        
        if(root.data < left.max || root.data > right.min) isbst = false;
        else if(!left.isbst || !right.isbst) isbst = false;
        
        BSTReturn node = new BSTReturn(min, max, isbst);
        return node;
        
    }
class BSTReturn{
    //BinaryTreeNode<Integer> data;
    int min;
    int max;
    boolean isbst;
    public BSTReturn(int min, int max, boolean isbst){
       // this.data = data;
        this.min = min;
        this.max = max;
        this.isbst = isbst;
    }
}
 */
    
}