import java.util.* ;
import java.io.*; 
public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Write your code here.
       if(arr.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        
        for(int el : arr) set.add(el);
        
        int mx = 1;
        
        for(int el : arr){
            
            if(!set.contains(el-1)){
                int curr = el;
                int count = 1;
                while(set.contains(curr+1)){
                    curr += 1;
                    count++;
                }
                mx = Math.max(mx, count);
            }
        }
        return mx;
    }
}