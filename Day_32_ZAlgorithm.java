public class Solution {

	public static int zAlgorithm(String s, String p, int n, int m) {
		int i = 0, count = 0;
        while(i <= n-m){
            if(s.substring(i,i+m).equals(p)) count++;
            i++;
        }
        return count;

	}

}