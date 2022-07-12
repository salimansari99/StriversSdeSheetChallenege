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

import java.util.ArrayList;
import java.util.HashMap;

public class Solution 
{
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer>  inorder, ArrayList<Integer>  preorder) 
    {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.size(); i++){
            inMap.put(inorder.get(i), i);
        }
        int in = inorder.size();
        int pre = preorder.size();
        TreeNode<Integer> root = builtBTHelper(inorder, 0, in-1, preorder, 0, pre-1, inMap);
        return root;
    }
    public static TreeNode<Integer> builtBTHelper(ArrayList<Integer> inorder, int inStart, int inEnd, ArrayList<Integer> preorder, int preStart, int preEnd, HashMap<Integer,Integer> inMap){
        
        if(inStart > inEnd || preStart > preEnd) return null;
        
        TreeNode<Integer> root = new TreeNode<>(preorder.get(preStart));
        
        int inRoot = inMap.get(root.data);
        int numsleft = inRoot - inStart;
        
        root.left = builtBTHelper(inorder, inStart, inRoot-1, preorder, preStart+1, preStart+numsleft, inMap);
        root.right = builtBTHelper(inorder, inRoot+1, inEnd, preorder, preStart+numsleft+1, preEnd, inMap);
        
        return root;
    }
}