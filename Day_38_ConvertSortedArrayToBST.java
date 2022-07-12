/****************************************************************

    Following is the class structure of the TreeNode class:

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


*****************************************************************/

import java.util.ArrayList;

public class Solution {
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        
        return arrToBST(arr, 0, n-1);
    }
    public static TreeNode<Integer> arrToBST(ArrayList<Integer> arr, int s, int e){
        if(s > e) return null;
        
        int mid = (s+e)/2;
        TreeNode<Integer> root = new TreeNode<>(arr.get(mid));
        
        root.left = arrToBST(arr, s, mid-1);
        root.right = arrToBST(arr, mid+1, e);
        return root;
        
    }
}
