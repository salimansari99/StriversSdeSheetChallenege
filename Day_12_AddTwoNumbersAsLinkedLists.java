import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

*****************************************************************/


public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        
        int carry = 0;
        LinkedListNode head = new LinkedListNode(-1);
        LinkedListNode tail = head;
        while(head1 != null && head2 != null){
            int sum = head1.data + head2.data + carry;
            LinkedListNode node  = new LinkedListNode(sum%10);
            tail.next = node;
            tail = node;
            carry = sum/10;
            head1 = head1.next;
            head2 = head2.next;
        }
        while(head1 != null){
            int sum = head1.data + carry;
            LinkedListNode node  = new LinkedListNode(sum%10);
            tail.next = node;
            tail = node;
            carry = sum/10;
            head1 = head1.next;
        }
         while(head2 != null){
            int sum = head2.data + carry;
            LinkedListNode node  = new LinkedListNode(sum%10);
            tail.next = node;
            tail = node;
            carry = sum/10;
            head2 = head2.next;
        }
        if(carry != 0){
            LinkedListNode node = new LinkedListNode(carry);
            tail.next = node;
            tail = node;
        }
        return head.next;
    }
}