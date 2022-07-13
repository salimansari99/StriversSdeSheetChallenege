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

    public static int floorInBST(TreeNode<Integer> root, int X) {
        
        TreeNode<Integer> curr = root;
        int floor = -1;
        while(curr != null){
            if(curr.data > X){
                curr = curr.left;
            }
            else{
                floor = curr.data;
                curr = curr.right;
            }
        }
        return floor;
    }
}