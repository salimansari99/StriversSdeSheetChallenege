/************************************************************

    Following is the TreeNode class structure

	class TreeNode<T> 
	{
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) 
	    {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

************************************************************/


public class Solution 
{
    static int ans = 0;
	public static int kthSmallest(TreeNode<Integer> root, int k) 
	{
		int[] cnt = new int[1];
        cnt[0] = 0;
       kthsmaller(root, k,cnt);
        return ans;
	}
    public static void kthsmaller(TreeNode<Integer> root, int k, int[] cnt){
        if(root == null) return;
        kthsmaller(root.left,k,cnt);
        cnt[0]++;
        if(cnt[0] == k){
            ans = root.data;
            return;
        } 
        kthsmaller(root.right,k,cnt);
    }

}
