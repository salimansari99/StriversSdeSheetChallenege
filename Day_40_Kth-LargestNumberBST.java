/*************************************************************
    Following is the Binary Search Tree node structure

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

*************************************************************/

import java.util.*;

public class Solution {
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		if(root == null) return -1;
        
        int n = countNodes(root);
        k = n-k+1;
        int[] cnt = new int[1];
        cnt[0] = 0;
        int[] ans = new int[1];
        ans[0] = -1;
        inorder(root,k,cnt,ans);
        return ans[0];
	}
    public static void inorder(TreeNode<Integer> root, int k, int[] cnt,int[] ans){
        if(root == null) return;
       
        inorder(root.left, k, cnt, ans);
         cnt[0]++;
        if(cnt[0] == k){
            ans[0] = root.data;
            return;
        }
        inorder(root.right, k, cnt, ans);
    }
    public static int countNodes(TreeNode<Integer> root){
        if(root == null) return 0;
        
        int cnt = 0;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            cnt++;
            if(node.right != null) s.push(node.right);
            if(node.left != null) s.push(node.left);
        }
        return cnt;
    }
}