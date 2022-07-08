/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.*;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        if(root == null) return res;
        
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            res.add(q.peek().data);
             while(n-- > 0){
               TreeNode<Integer> node = q.poll();
                 if(node.left != null){
                     q.add(node.left);
                 }
                 if(node.right != null){
                     q.add(node.right);
                 }
             }
        }
        return res;
    }
}
