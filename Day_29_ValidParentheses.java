import java.util.*;
public class Solution {
    public static boolean isValidParenthesis(String expression) {
        
        Stack<Character> st = new Stack<>();
        
        int i = 0, n = expression.length();
        while(i < n){
            char ch = expression.charAt(i);
            if(isOpening(ch)){
                st.push(ch);
            }
            else{
                if(st.isEmpty()) return false;
                if(isMatching(ch,st) == false) return false;
                st.pop();
            }
             i++;
        }
        return st.isEmpty();
    }
    public static boolean isOpening(char ch){
        return ch == '(' || ch == '[' || ch == '{';
    }
    public static boolean isMatching(char ch, Stack<Character> st){
        if(ch == ')' && st.peek() == '(') return true;
         if(ch == ']' && st.peek() == '[') return true;
         if(ch == '}' && st.peek() == '{') return true;
        return false;
    }
}