import java.util.*;
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		 if(stack.size() <= 1) return;
        
        int temp = stack.pop();
        sortStack(stack);
        insert(stack,temp);
	}
    public static void insert(Stack<Integer> stack, int temp){
        if(stack.size() == 0 || stack.peek() <= temp){
         stack.push(temp);
            return;
        }
        
        int val = stack.pop();
        insert(stack,temp);
        stack.push(val);
    }

}