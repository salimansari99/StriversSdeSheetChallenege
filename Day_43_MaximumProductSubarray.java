import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		//if(n == 0) return 0;
        int mxend = arr.get(0);
        int minend = arr.get(0);
        int mxoverall = arr.get(0);
        
        for(int i = 1; i < n; i++){
            int temp = mxend;
            mxend = Math.max(arr.get(i), Math.max(mxend*arr.get(i), minend*arr.get(i)));
            minend = Math.min(arr.get(i), Math.min(temp*arr.get(i), minend*arr.get(i)));
            mxoverall = Math.max(mxoverall, mxend);
        }
        return mxoverall;
	}
}

/* BRUTE FORCE
public static int maximumProduct(ArrayList<Integer> arr, int n) {
        
        // BRUTE FORCE
        int mx = Integer.MIN_VALUE;
        int prod = 0;
        for(int i = 0; i < n; i++){
            prod = arr.get(i);
            mx = Math.max(mx, prod);
            for(int j = i+1; j < n; j++){
                prod = prod*arr.get(j);
                mx = Math.max(mx, prod);
            }
        }
        return mx;
    }
*/

