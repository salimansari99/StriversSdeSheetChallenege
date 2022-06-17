import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
		{
		    public int data;
		    public Node next;

		    Node(int data)
		    {
		        this.data = data;
		        this.next = null;
		    }
		}

*****************************************************************/

public class Solution 
{
    public static Node firstNode(Node head) 
    {
       
        Node temp = checkCycle(head);
        if(temp == null) return null;
        
        // calculate length of ycle
        int count = 1;
        Node next = temp.next;
        while(next != temp){
            next = next.next;
            count++;
        }
        /* take two pointer where first pointer will point at head whereas another will point at dist of length of cycle forward */
        Node p1 = head;
        Node p2 = head;
        int i = 0;
        while(i < count){
            p2 = p2.next;
            i++;
        }
        
        while(p2 != p1){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
    public static Node checkCycle(Node head){
        Node sl = head, f = head;
        while(f != null && f.next != null){
            sl = sl.next;
            f =f.next.next;
            if(sl == f) return sl;
        }
        return null;
    }
}















