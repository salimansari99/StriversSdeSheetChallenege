/************************************************************
  
   Following is the TreeNode class structure
   
   class TreeNode<T> { 
        T data; 
        TreeNode<T> left;
        TreeNode<T> right;
  
        TreeNode(T data) { 
            this.data = data; 
            left = null; 
            right = null; 
        }
   }
    
 ************************************************************/
import java.util.HashMap;
public class Solution {
    public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
        int in = inOrder.length;
        int post = postOrder.length;
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i = 0; i < in; i++){
            inMap.put(inOrder[i], i);
        }
        
        TreeNode<Integer> root = helper(inOrder, 0, in-1, postOrder, 0, post-1, inMap);
        return root;
    }
    public static TreeNode<Integer> helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer,Integer> inMap){
        
        if(inStart > inEnd || postStart > postEnd) return null;
        
        TreeNode<Integer> root = new TreeNode<>(postorder[postEnd]);
        int inRoot = inMap.get(postorder[postEnd]);
        int numsleft = inRoot - inStart;
        
        root.left = helper(inorder, inStart, inRoot-1, postorder, postStart, postStart+numsleft-1, inMap);
        
        root.right = helper(inorder, inRoot+1, inEnd, postorder, postStart+numsleft, postEnd-1, inMap);
        return root;
    }
}