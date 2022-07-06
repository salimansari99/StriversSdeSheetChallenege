public class Solution {
    public static boolean findPattern(String p, String s) {
        int i = 0;
        int n = p.length();
        int m = s.length();
        int pval = 0, sval = 0;
        for(int k = 0; k < n; k++){
            pval += (int)p.charAt(k);
            sval += (int)s.charAt(k);
        }
        
        while(i <= m-n){
            if(pval == sval && s.substring(i,i+n).equals(p)) return true;
            if(i < m-n){
            sval += (int)s.charAt(i+n);
            sval -= (int)s.charAt(i);
            }
            i++;
        }
        return false;
    }
}