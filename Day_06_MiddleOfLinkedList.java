import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

       class Node 
        { 
        public:
            int data;
            Node next;
            Node(int data) 
            {
              this.data = data;
              this.next = null;
            }
        };

*****************************************************************/

public class Solution {
    public static Node findMiddle(Node head) 
    {
        Node sl = head, f = head;
        while(f != null && f.next != null){
            sl = sl.next;
            f = f.next.next;
        }
        return sl;
    }
}
