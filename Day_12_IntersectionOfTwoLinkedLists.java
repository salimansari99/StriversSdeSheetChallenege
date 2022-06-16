import java.util.* ;
import java.io.*; 
/************************************
	 
	 //Following is the class structure of the LinkedListNode class:
	 
	  class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;
		
		public LinkedListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

*****************************************/
public class Solution {

	public static int findIntersection(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) {
		LinkedListNode<Integer> A = firstHead;
        LinkedListNode<Integer> B = secondHead;
        
        while(A != B){
            A = A == null ? secondHead : A.next;
            B = B == null ? firstHead : B.next;
        }
       return A == null ? -1 : A.data;
	}
}