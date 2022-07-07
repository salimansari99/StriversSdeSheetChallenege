public class Solution 
{
    public static String writeAsYouSpeak(int n) 
    {
        if(n == 1) return "1";
        if(n == 2) return "11";
        
        String res = "11";
        for(int i = 3; i <= n; i++){
            res += '$';
            
            String temp = "";
            int cnt = 1;
            for(int j = 1; j < res.length(); j++){
                if(res.charAt(j)==res.charAt(j-1)){
                    cnt++;
                }
                else if(res.charAt(j)!=res.charAt(j-1)){
                    temp += Integer.toString(cnt);
                    temp += res.charAt(j-1);
                    cnt = 1;
                }
            }
            res = temp;
        }
        return res;
    }
}