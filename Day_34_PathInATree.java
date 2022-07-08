/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/
import java.util.*;
public class Solution {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        path(root,x,res);
        return res;
    }
    public static void path(TreeNode root, int x, ArrayList<Integer> res){
        if(root == null) return;
        if(root.data == x){
            res.add(root.data);
            return;
        }
        path(root.left,x, res);
        if(res.size() != 0){
            res.add(0,root.data);
            return;
        }
        path(root.right,x,res);
       if(res.size() != 0){
            res.add(0,root.data);
            return;
        }
        
    }
}