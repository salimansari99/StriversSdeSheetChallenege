import java.util.*;
public class Solution {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partition(s,0,new ArrayList<String>(),res);
        return res;
    }
    public static void partition(String s, int ind ,ArrayList<String> ds, List<List<String>> res){
        if(ind == s.length()){
            res.add(new ArrayList<String>(ds));
            return;
        }
        for(int i = ind; i < s.length(); i++){
            if(palindrome(s,ind,i)){
            ds.add(s.substring(ind,i+1));
            partition(s,i+1,ds,res);
            ds.remove(ds.size()-1);
            }
        }
    }
    public static boolean palindrome(String s,int lo, int hi){
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }
}