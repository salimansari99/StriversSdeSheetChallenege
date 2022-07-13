/*************************************************************************

    Following is the class structure of the Node class:

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

*************************************************************************/

public class Solution {
	public static int largestBST(TreeNode<Integer> root) {
		if(root == null) return 0;
        int[] ans = new int[1];
        ans[0] = 0;
        largestBSTHelper(root, ans);
        return ans[0];
	}
    public static BSTReturn largestBSTHelper(TreeNode<Integer> root, int[] ans){
        if(root == null){
            BSTReturn bstreturn = new BSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
            return bstreturn;
        }
        
        BSTReturn left = largestBSTHelper(root.left, ans);
        BSTReturn right = largestBSTHelper(root.right, ans);
        
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));
        
        boolean isbst = true;
        if(root.data < left.max || root.data > right.min) isbst = false;
        else if(!left.isbst || !right.isbst) isbst = false;
        if(isbst){
            ans[0] = Math.max(ans[0], left.size+right.size+1);
        }
        BSTReturn bstreturn = new BSTReturn(min, max, isbst, left.size+right.size+1);
        return bstreturn;
    }
}
class BSTReturn{
    int min;
    int max;
    boolean isbst;
    int size;
    public BSTReturn(int min, int max, boolean isbst, int size){
        this.min = min;
        this.max = max;
        this.isbst = isbst;
        this.size = size;
    }
}