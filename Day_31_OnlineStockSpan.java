import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        int n = price.size();
        ArrayList<Integer> res = new ArrayList<>();
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        res.add(1);
        
        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && price.get(st.peek()) <= price.get(i))
                st.pop();
            
            int span = st.isEmpty() ? i+1 : i-st.peek();
            res.add(span);
            st.push(i);
        }
       return res; 
    }
}