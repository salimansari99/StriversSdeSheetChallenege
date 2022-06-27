public class Solution {
    public static double findNthRootOfM(int n, long m) {
    	//shortcut
        return nthroot(n,m);
    }
        /*
        double lo = 1, hi = m;
        double eps = 1e-7;
        
        while((hi - lo) > eps){
            double mid = lo + (hi - lo)/2.0;
            if(mul(mid,n) < m) lo = mid;
            else hi = mid;
        }
        return lo;
        
    }
    public static double mul(double m, int n){
        double ans = 1.0;
        for(int i = 1; i <= n; i++){
            ans = ans*m;
        }
        return ans;
    }
    */
    public static double nthroot(int n, long m){
        return Math.pow(m,1.000000/n);
    }
}