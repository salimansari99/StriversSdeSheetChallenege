import java.util.*;
public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
		
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
       
        int i = 0;
        while(i < n){
            
            if(st.isEmpty() || arr[i] <= arr[st.peek()]){
                st.push(i);
                i++;
            }
            else{
                while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                    res[st.pop()] = arr[i];
                   
                }
            }
        }
        while(!st.isEmpty()){
            res[st.pop()] = -1;
          
        }
		return res;
	}

}
