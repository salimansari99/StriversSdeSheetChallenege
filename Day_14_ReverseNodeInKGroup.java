import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
		return kHelper(head,n,0,b);
	}
    public static Node kHelper(Node head, int n, int i, int[] b){
        if(head == null || head.next == null) return head;
        if(i == n) return head;
        Node temp = head;
        int pos = b[i];
        if(pos == 0) return kHelper(head, n, i+1,b);
       
        int count = 1;
        while(count < pos && temp != null){
            temp = temp.next;
            count++;
        }
        if(temp == null){
           return reverse(head,count-1);
        }
        Node nextNode = temp.next;
        Node newHead = reverse(head,b[i]);
        Node nhead = kHelper(nextNode,n,i+1,b);
        head.next = nhead;
        return newHead;
    }
    public static Node reverse(Node head, int k){
        if(head == null || head.next == null) return head;
        if(k==0 || k == 1) return head;
        
        Node tail = head.next;
        Node newHead = reverse(head.next,k-1);
        tail.next = head;
        head.next = null;
        return newHead;
    }
}