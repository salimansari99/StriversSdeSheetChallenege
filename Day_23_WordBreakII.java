import java.util.*;

public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		
        HashSet<String> set = new HashSet<>();
        for(String el : dictionary){
            set.add(el);
        }
        ArrayList<String> res = new ArrayList<>();
        wordBreakHelper(s,"",res,set);
        return res;
	}
    public static void wordBreakHelper(String s, String osf, ArrayList<String> res,HashSet<String> set){
        if(s.length() == 0){
            res.add(osf);
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.substring(0,i+1))){
              String left = s.substring(0,i+1);
                String right = s.substring(i+1);
                wordBreakHelper(right,osf+left+" ",res,set);
             }
        }
    }
}