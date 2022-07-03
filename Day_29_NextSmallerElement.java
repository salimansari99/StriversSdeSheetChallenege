import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        
        Stack<Integer> st = new Stack<>();
        
        int i = 0;
        while(i < n){
            if(st.isEmpty() || arr.get(i) >= arr.get(st.peek())){
                st.push(i);
                i++;
            }
            else{
                while(!st.isEmpty() && arr.get(i) < arr.get(st.peek())){
                    arr.set(st.pop(), arr.get(i));
                }
            }
        }
        while(!st.isEmpty()){
            arr.set(st.pop(), -1);
        }
        return arr;
    }
}