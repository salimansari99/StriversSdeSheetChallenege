import java.util.* ;
import java.io.*; 
/***********************************************
    Following is the class structure of the Node class:

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        if(head == null || head.next == null) return head;
      
        int len = length(head);
        k = k%len;
        if(k==0) return head;
        
        int pos = len - k;
        int i = 0;
        Node newHead = null,prev = null, temp = head;
        while(i < pos){
            prev = temp;
            temp = temp.next;
            i++;
        }
        newHead = temp;
        
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        prev.next = null;
        return newHead;
        
        
    }
    public static int length(Node head){
        int c = 0;
        while(head != null){
            head = head.next;
            c++;
        }
        return c;
    }
}