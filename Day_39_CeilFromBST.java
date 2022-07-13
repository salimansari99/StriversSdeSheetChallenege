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

public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {

        TreeNode<Integer> curr = node;
        
        int ceil = -1;
        while(curr != null){
            if(curr.data < x){
                curr = curr.right;
            }
            else{
                ceil = curr.data;
                curr = curr.left;
            }
        }
        return ceil;

    }
}
