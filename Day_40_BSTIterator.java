/*
    Definition of Node class for reference

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

*/
import java.util.*;
public class Solution {
static Stack<TreeNode<Integer>> st = new Stack<>();
    static class BSTIterator{

        BSTIterator(TreeNode<Integer> root){
            pushAll(root);
        }

        int next(){
            TreeNode<Integer> temp = st.pop();
            pushAll(temp.right);
            return temp.data;
        }

        boolean hasNext(){
           return !st.isEmpty();
        }
    }
    public static void pushAll(TreeNode<Integer> root){
        for(; root != null; st.push(root), root = root.left);
    }
}

/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/
