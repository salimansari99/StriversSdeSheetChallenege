/************************************************************

    Following is the TreeNode class structure

    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	   }
	}


************************************************************/
import java.util.*;
public class Solution {
	public static int getMaxWidth(TreeNode root) {
		if(root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int mx = 1;
        
        while(true){
            int n = q.size();
            if(n == 0) break;
            mx = Math.max(mx, n);
            while(n-- > 0){
              TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            } 
        }
        return mx;
	}
}