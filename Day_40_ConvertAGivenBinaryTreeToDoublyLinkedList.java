
/*************************************************************
 class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*************************************************************/

import java.util.*;
public class Solution {
	
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
		ArrayList<Integer> al = new ArrayList<>();
        inorder(root,al);
        
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(-1);
        BinaryTreeNode<Integer> t = newNode;
        for(int i = 0; i < al.size(); i++){
            newNode.right = new BinaryTreeNode<Integer>(al.get(i));
            BinaryTreeNode<Integer> x = newNode.right;
            x.left = newNode;
            newNode = newNode.right;
        }
        return t.right;
	}
    public static void inorder(BinaryTreeNode<Integer> root, ArrayList<Integer> al){
        if(root == null) return;
        
        inorder(root.left,al);
        al.add(root.data);
        inorder(root.right, al);
    }
	

}
