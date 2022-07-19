import java.util.*;
 class Pair{
     int num;
     int min;
     public Pair(int n, int m){
         num = n;
         min = m;
     }
 }
public class Solution {

    static class MinStack {
        Stack<Pair> st;

        MinStack() {
            // Write your code here.
            st = new Stack<Pair>();
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            // Write your code here.
            int min = Integer.MAX_VALUE;
            if(st.isEmpty()) min = num;
            else{
                min = Math.min(num, st.peek().min);
            }
            st.push(new Pair(num, min));

            
        }

        // Function to remove the top element of the stack.
        int pop() {
            // Write your code here.
            return st.isEmpty() ? -1 : st.pop().num;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            // Write your code here.
            return st.isEmpty() ? -1 : st.peek().num;
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            // Write your code here.
           return st.isEmpty() ? -1 : st.peek().min; 
        }
    }
}