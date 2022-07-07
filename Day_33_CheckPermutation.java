import java.util.*;
public class Solution {
    public static boolean areAnagram(String str1, String str2){
        
        int n = str1.length();
        int m = str2.length();
        
        if(n != m) return false;
        
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            map1.put(c1, map1.getOrDefault(c1,0)+1);
            map2.put(c2,map2.getOrDefault(c2,0)+1);
        }
        if(map1.equals(map2)) return true;
        return false;
        
        
    }
}