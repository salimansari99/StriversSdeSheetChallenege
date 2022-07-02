import java.util.*;
public class Stack {

    // Define the data members.
    Queue<Integer> q1;
    Queue<Integer> q2;


    public Stack() {
        // Implement the Constructor.
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        // Implement the getSize() function.
        return q1.size();
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function.
        return q1.size() == 0;
    }

    public void push(int element) {
        // Implement the push(element) function.
        q1.offer(element);
    }

    public int pop() {
        // Implement the pop() function.
        if(q1.size() == 0) return -1;
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        int popped = q1.poll();
         while(q2.size() > 0){
            q1.add(q2.poll());
        }
        return popped;
    }

    public int top() {
        // Implement the top() function.
         if(q1.size() == 0) return -1;
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        int peek = q1.poll();
        q2.add(peek);
         while(q2.size() > 0){
            q1.add(q2.poll());
        }
        return peek;
        
    }
}