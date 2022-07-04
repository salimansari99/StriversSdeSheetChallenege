import java.util.*;

public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) {
    
      Stack<Integer> st = new Stack<>();
      int i = 0, n = heights.size(), mx_area = 0;
      
      while(i < n){
          if(st.isEmpty() || heights.get(i) >= heights.get(st.peek())){
              st.push(i);
              i++;
          }
          else{
              int x = st.pop();
              int right = i;
              int left;
              if(st.isEmpty()){
                  left = 0;
              }
              else left = st.peek();
              int area;
              if(st.isEmpty()){
                  area = heights.get(x)*right;
              }
              else area = heights.get(x)*(right - left - 1);
              
              mx_area = Math.max(mx_area,area); 
          }
      }
      
      while(!st.isEmpty()){
              int x = st.pop();
              int right = i;
              int left;
              if(st.isEmpty()){
                  left = 0;
              }
              else left = st.peek();
              int area;
              if(st.isEmpty()){
                  area = heights.get(x)*right;
              }
              else area = heights.get(x)*(right - left - 1);
              
              mx_area = Math.max(mx_area,area); 
          }
      
      return mx_area;
  }
}