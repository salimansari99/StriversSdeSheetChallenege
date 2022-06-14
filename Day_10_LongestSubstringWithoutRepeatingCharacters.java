import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String input) 
    {
        int n = input.length();
		HashMap<Character,Integer> map = new HashMap<>();
        int i = 0, j = 0, mx = 0;
          while(j < n){
              char ch = input.charAt(j);
            map.put(ch, map.getOrDefault(ch,0)+1);
            while(map.size() < j-i+1){
                if(map.get(input.charAt(i))==1) map.remove(input.charAt(i));
                else map.put(input.charAt(i), map.get(input.charAt(i))-1);
                i++;
            }
              mx = Math.max(mx, map.size());
              j++;
        }
        return mx;
    }
}
