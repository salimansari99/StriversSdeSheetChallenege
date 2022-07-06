import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> stringMatch(String str, String pat) {
		
        ArrayList<Integer> res = new ArrayList<>();
        
        int j = 0;
        int n = str.length();
        int m = pat.length();
        while(j <= n-m){
            if(str.substring(j,j+m).equals(pat)) res.add(j);
            j++;
        }
        return res;
	}
}