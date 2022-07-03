import java.util.*;
public class Queue {
    // Define the data members(if any) here.
    Stack<Integer> st1;
    Stack<Integer> st2;
    Queue() {
        // Initialize your data structure here.
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    void enQueue(int val) {
        // Implement the enqueue() function.
        st1.push(val);
    }

    int deQueue() {
        // Implement the dequeue() function.
        if(st1.size() == 0) return -1;
        while(st1.size() > 1){
            st2.push(st1.pop());
        }
        int deq = st1.pop();
         while(st2.size() > 0){
            st1.push(st2.pop());
        }
        return deq;
    }

    int peek() {
        // Implement the peek() function here.
        if(st1.size() == 0) return -1;
        while(st1.size() > 0){
            st2.push(st1.pop());
        }
        int peek = st2.peek();
         while(st2.size() > 0){
            st1.push(st2.pop());
        }
        return peek;
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here.
        return st1.isEmpty();
    }
}