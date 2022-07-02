class Node{
    int data;
    Node next;
         public Node(int data){
           this.data = data;
           }       
}
public class Queue {
    Node tail;
    Node head;
    Queue() {
        // Implement the Constructor
        head = null;
        tail = null;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        return head == null;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
        }
        else{
        tail.next = node;
        tail = node;
        }
    }

    int dequeue() {
        // Implement the dequeue() function
        if(head == null) return -1;
        int ele = head.data;
        head = head.next;
        return ele;
        
    }

    int front() {
        // Implement the front() function
        if(head == null) return -1;
        return head.data;
    }

}
