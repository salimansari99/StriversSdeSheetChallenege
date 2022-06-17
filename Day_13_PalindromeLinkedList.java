import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if(head == null || head.next == null) return true;
		LinkedListNode<Integer> mid = middle(head);
        LinkedListNode<Integer> last = reverse(mid);
        LinkedListNode<Integer> curr = head;
        while(last != null){
            if(!curr.data.equals(last.data)) return false;
            last = last.next;
            curr = curr.next;
        }
        return true;
	}
    public static LinkedListNode<Integer> middle(LinkedListNode<Integer> head){
        LinkedListNode<Integer> sl = head, f = head;
        while(f != null && f.next != null){
            sl = sl.next;
            f = f.next.next;
        }
        return sl;
    }
    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
        LinkedListNode<Integer> temp = null, next = head;
        while(head != null){
            next = next.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }
}