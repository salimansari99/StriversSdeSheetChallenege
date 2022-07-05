public class Solution {	
	public static String longestPalinSubstring(String str) {
		String max = "";
        for(int i = 0; i < str.length(); i++){
            String s1 = palindrome(i,i,str);
            String s2 = palindrome(i,i+1,str);
            String res = "";
            if(s1.length() <= s2.length()) res = s2;
            else  res = s1;
            max = res.length() <= max.length() ? max : res;
        }
        return max;
	}
    public static String palindrome(int i, int j, String s){
        while(i >= 0 && j < s.length()){
            if(s.charAt(i) != s.charAt(j)) break;
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}
