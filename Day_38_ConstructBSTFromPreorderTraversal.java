 
 
/*************************************************************
	Following is the Binary Tree node structure
	class TreeNode<T> {
		public T data;
		public TreeNode<T> left;
		public TreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = right = null;
		}

};************************************************************/
public class Solution {
 
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
        
        return BST(preOrder, Integer.MAX_VALUE, new int[]{0});  
	}
    
    public static TreeNode<Integer> BST(int[] A, int bound, int[] i){
        
        if(i[0] == A.length || A[i[0]] > bound) return null;
        
        TreeNode<Integer> root = new TreeNode<>(A[i[0]++]);
        
        root.left = BST(A, root.data, i);
        root.right = BST(A, bound, i);
        return root;
    }

}
