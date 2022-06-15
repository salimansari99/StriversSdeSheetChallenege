import java.util.* ;
import java.io.*; 
/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}

*/
public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        
        // ITERATIVE METHOD
        LinkedListNode<Integer> temp = null, next = null;
        while(head != null){
            next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }
    // RECURSIVE METHOD
    /*
    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer>  head)     {
        if(head == null || head.next == null) return head;
        LinkedListNode<Integer> tail = head.next;
        LinkedListNode<Integer> newHead = reverse(head.next);
        tail.next = head;
        head.next = null;
        return newHead;
    }
    */
}