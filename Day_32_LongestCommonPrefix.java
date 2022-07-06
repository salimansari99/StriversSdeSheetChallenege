import java.util.*;
public class Solution {
	public static String longestCommonPrefix(String[] arr, int n) {
		
        Arrays.sort(arr);
        
        String res = "";
        
        int len = Math.min(arr[0].length(), arr[n-1].length());
        int i = 0;
        while(i < len && arr[0].charAt(i) == arr[n-1].charAt(i)){
            i++;
        }
        return arr[0].substring(0,i);
        
	}

}
