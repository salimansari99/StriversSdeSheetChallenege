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
    public static String serializeTree(TreeNode<Integer> root)
    {
       
        if(root == null) return "";
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode front = q.poll();
            if(front == null){
                sb.append("n ");
                continue;
            }
            sb.append(front.data+" ");
            q.add(front.left);
            q.add(front.right);
        }
        return sb.toString();
    }
    
    public static TreeNode<Integer> deserializeTree(String str)
    {
        //    Write your code here for deserialization of the tree.
        if(str == null || str.length() == 0) return null;
        
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        String[] values = str.split(" ");
        TreeNode<Integer> root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i = 1; i < values.length; i++){
            TreeNode parent = q.poll();
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if(!values[++i].equals("n")){
              TreeNode right = new TreeNode(Integer.parseInt(values[i]));
              parent.right = right;
              q.add(right);
            }
        }
        return root;
    }
}
