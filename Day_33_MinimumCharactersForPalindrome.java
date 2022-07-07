
public class Solution {

    public static int minCharsforPalindrome(String str) {
       
        int n = str.length();
        int cnt = 0;
        for(int i = n-1; i >= 0; i--){
           if(ispalindrome(str,0,i)) return cnt;
            else cnt++;
        }
        return cnt;
    }
        public static boolean ispalindrome(String s, int i, int j){
                
                while(i < j){
                    if(s.charAt(i) != s.charAt(j)) return false;
                    i++;
                    j--;
                }
                return true;
            }
}