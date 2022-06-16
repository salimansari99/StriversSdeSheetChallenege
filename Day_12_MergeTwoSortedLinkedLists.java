import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
	
      LinkedListNode<Integer> h1 = first, h2 = second;
      LinkedListNode<Integer> head = null, tail = null;
        if(h1==null && h2==null) return null;
        if(h2==null) return h1;
        if(h1==null) return h2;
        if(h1.data<= h2.data){
            head = h1;
            tail = h1;
            h1 = h1.next;
        }
        else{
            head = h2;
            tail = h2;
            h2 = h2.next;
        }
        while(h1 != null && h2 != null){
            if(h1.data <= h2.data){
                tail.next = h1;
                tail = h1;
                h1 = h1.next;
            }
            else{
                tail.next = h2;
                tail = h2;
                h2 = h2.next;
            }
        }
        
        if(h1 != null){
            tail.next = h1;
            tail = h1;
        }
        if(h2 != null){
            tail.next = h2;
            tail = h2;
        }
        return head;
	}
}
