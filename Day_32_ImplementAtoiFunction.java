public class Solution {
    public static int atoi(String str) {
        String res = "";
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') res += c;
        }
        
        if(res.isEmpty()) return 0;
        int ans = Integer.parseInt(res);
        if(str.charAt(0) == '-') return -ans;
        return ans;
    }
}
