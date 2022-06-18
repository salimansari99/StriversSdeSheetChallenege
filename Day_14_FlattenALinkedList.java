import java.util.* ;
import java.io.*; 
/****************************************************************

       Following is the class structure of the Node class:

       class Node {
	int data;
	Node next;
	Node child;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.child = null;
	}
}

*****************************************************************/
public class Solution {
	public static Node flattenLinkedList(Node start) {
		
        if(start == null || start.next == null) return start;
        start.next = flattenLinkedList(start.next);
        start = mergeTwoSortedLL(start,start.next);
        return start;
   
	}
    public static Node mergeTwoSortedLL(Node h1, Node h2){
  
        Node head = null, tail = null;
//         head = new Node(0);
//         tail = head;
        if(h1.data <= h2.data){
            head = h1;
            tail = h1;
            h1 = h1.child;
        }
        else{
            head = h2;
            tail = h2;
            h2 = h2.child;
        }
        while(h1 != null && h2 != null){
            if(h1.data <= h2.data){
                tail.child = h1;
                tail = h1;
                h1 = h1.child;
            }
            else{
                tail.child = h2;
                tail = h2;
                h2 = h2.child;
            }
        }
        if(h1 != null){
            tail.child = h1;
            tail = h1;
        }
        if(h2 != null){
            tail.child = h2;
            tail = h2;
        }
        return head;
    }
}

