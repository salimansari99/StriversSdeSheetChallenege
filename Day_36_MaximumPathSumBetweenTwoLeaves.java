/************************************************************

    Following is the Tree node structure
	
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

************************************************************/

public class Solution {
	public static long findMaxSumPath(TreeNode root) {
		
        long[] max = new long[1];
        max[0] = 0l;
        //if(root == null) return max[0];
        if(root == null || root.left == null || root.right == null) return -1;
        maxPath(root, max);
        return max[0];
	}
    public static long maxPath(TreeNode root, long[] max){
        if(root == null) return 0l;
        
        long left = Math.max(0l, maxPath(root.left,max));
        long right = Math.max(0l, maxPath(root.right, max));
        
        max[0] = Math.max(max[0], left + right + (long)root.data);
        return (long)root.data + Math.max(left,right);
    }
}