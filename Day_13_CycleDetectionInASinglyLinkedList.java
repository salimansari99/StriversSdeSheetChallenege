import java.util.* ;
import java.io.*; 
/*  

    Following is the representation of the Singly Linked List node

    class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

*/

public class Solution {
    
    public static boolean detectCycle(Node<Integer> head) {
       Node<Integer> sl = head, f = head;
        
        while(f != null && f.next != null){
            sl = sl.next;
            f = f.next.next;
            if(sl == f) return true;
        }
        return false;
    }
}