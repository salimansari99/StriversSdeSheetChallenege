import java.util.*;
public class Solution {
    public static int removeDuplicates(ArrayList<Integer> arr,int n) {
        if(n <= 1) return n;
        int cnt = 1;
        for(int i = 1; i < n; i++){
        if(arr.get(i-1)==arr.get(i)) continue;
        else cnt++;
        }
        return cnt;
    }
}