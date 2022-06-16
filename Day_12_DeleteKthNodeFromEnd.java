import java.util.* ;
import java.io.*; 
/****************************************************************
	
	Following is the structure of the Singly Linked List.
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

****************************************************************/

public class Solution {
	public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {
       if(head == null) return null;
        if(K == 0) return head;
	   int len = length(head);
        if(K==len) return head.next;
       
       int pos = len - K - 1;
        int i = 0;
        LinkedListNode<Integer> temp = head;
        while(i < pos && temp != null){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return head;
	}
    public static int length(LinkedListNode<Integer> head){
        int c = 0;
        while(head != null){
            head = head.next;
            c++;
        }
        return c;
    }
}
