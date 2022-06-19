import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		
        // Step 1 : Create copy of each Node and link
        LinkedListNode<Integer> next = null, curr = head;
        while(curr != null){
           next = curr.next;
            LinkedListNode<Integer> node = new LinkedListNode<Integer>(curr.data);
            curr.next = node;
            node.next = next;
            curr = next;
        }
        
        // Step 2 : random pointer
        
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // Step 3 : Extract deep copy
        
        LinkedListNode<Integer> pseudohead = new LinkedListNode<Integer>(0);
        LinkedListNode<Integer> tail = pseudohead;
        curr = head; next = null;
        while(curr != null){
           next = curr.next.next;
            tail.next = curr.next;
            tail = tail.next;
            
            curr.next = next;
            curr = next;
        }
        
        return pseudohead.next;
        
        
	}
}
