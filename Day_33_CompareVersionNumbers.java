public class Solution 
{
    public static int compareVersions(String a, String b) 
    {
       
        int i = 0, j = 0, alen = a.length(), blen =b.length();
        
        while(i < alen || j < blen){
            long ans1 = 0, ans2 = 0;
            
            while(i < alen && a.charAt(i) != '.'){
                ans1 = ans1*10 + (a.charAt(i)-'0');
                i++;
            }
             while(j < blen && b.charAt(j) != '.'){
                ans2 = ans2*10 + (b.charAt(j)-'0');
                 j++;
             }
            if(ans1 < ans2) return -1;
            else if(ans1 > ans2) return 1;
            
            i++;
            j++;
        }
        return 0;
    }
}